package us.supercheng.algorithm.problems.powerofthree;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        App app = new App();
        int num = 243;
        PrintHelper.echoLn("Is " + num + " Power of Three? " + app.isPowerOfThree(num));
        PrintHelper.echoLn("Is " + num + " Power of Three? " + app.isPowerOfThree2(num));

        Integer val = (int)Math.pow(3,19);
        // 1162261467
        PrintHelper.echoLn("The Biggest Number of Power of 3 in Integer: " + val);
        PrintHelper.echoLn("Is " + num + " Power of Three? " + app.isPowerOfThree3(num));
    }

    public boolean isPowerOfThree(int n) {
        if(n<1)
            return false;
        while(n!=1) {
            if(n % 3 != 0)
                return false;
            n /=3;
        }
        return true;
    }

    public boolean isPowerOfThree2(int n) {
        if(n<1)
            return false;
        while(n % 3 == 0) {
            n /=3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree3(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}