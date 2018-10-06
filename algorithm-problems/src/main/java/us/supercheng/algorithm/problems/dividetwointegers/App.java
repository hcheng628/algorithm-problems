package us.supercheng.algorithm.problems.dividetwointegers;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int divident = 1342123, divisor = 132;

        PrintHelper.echoLn(divident + " / " + divisor + " = " + new App().divide(divident, divisor));
    }

    public int divide(int dividend, int divisor) {
        if(divisor == 1)
            return dividend;

        boolean neg = (dividend < 0) != (divisor < 0);
        long dividendL = dividend, divisorL = divisor;

        if(dividendL < 0)
            dividendL = - (long) dividend;
        if(divisorL < 0)
            divisorL = - (long) divisor;

        long ret = this.helper(dividendL, divisorL);
        return neg ? (-ret<Integer.MIN_VALUE ? Integer.MIN_VALUE : -(int)ret) : (ret>Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)ret);
    }

    private long helper(long dividend, long divisor) {
        if(dividend < divisor)
            return 0;
        long count = 1, sum = divisor;
        for(;sum+sum < dividend; sum=sum<<1,count=count<<1){}
        return count + this.helper(dividend - sum, divisor);
    }
}