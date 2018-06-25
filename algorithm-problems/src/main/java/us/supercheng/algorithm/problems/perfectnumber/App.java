package us.supercheng.algorithm.problems.perfectnumber;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int num = 28282813;
        PrintHelper.echoLn(new App().checkPerfectNumber(num));
    }

    public boolean checkPerfectNumber(int num) {
        if(num == 1)
            return false;
        int sum = 1;
        for(int i=2;i*i<=num; i++) {
            if(num % i == 0) {
                sum += (num / i) + i;
                if(i*i == num)
                    sum -= i;
            }
            if(sum > num)
                return false;
        }
        return sum == num;
    }
}