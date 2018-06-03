package us.supercheng.algorithm.problems.poweroffour;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        App app = new App();
        int num = 4421;
        PrintHelper.echoLn("Is " + num + " Power of Four? " + app.isPowerOfFour(num));
        PrintHelper.echoLn("Is " + num + " Power of Four? " + app.isPowerOfFour2(num));

    }

    public boolean isPowerOfFour(int n) {
        if(n<1)
            return false;
        while(n!=1) {
            if(n % 3 != 0)
                return false;
            n /=3;
        }
        return true;
    }

    public boolean isPowerOfFour2(int n) {
        if(n<1)
            return false;
        while(n % 4 == 0) {
            n /=4;
        }
        return n == 1;
    }
}