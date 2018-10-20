package us.supercheng.algorithm.problems.powxn;

public class App {
    public double myPow(double x, int n) {
        if(n == 1)
            return x;
        if(n == 0)
            return 1.0;

        double res = 1, base = x;
        boolean powerFlag = n < 0, baseFlag = x < 0 && n % 2 != 0;
        if(powerFlag) {
            if(n == Integer.MIN_VALUE)
                n++;
            n = -n;
        }
        while(n != 0) {
            if(n % 2 != 0) {
                res *= base;
                n--;
            } else {
                base *= base;
                n /= 2;
            }
        }
        return  baseFlag ? -Math.abs(powerFlag ? 1/res : res) : Math.abs(powerFlag ? 1/res : res);
    }
}
