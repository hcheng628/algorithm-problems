package us.supercheng.algorithm.problems.leetcode.arrangingcoins;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int coins = 120;
        App app = new App();
        PrintHelper.echoLn("Valid Stairs: " + app.arrangeCoins(coins));
    }

    public int arrangeCoins(int n) {
        int count = 0;
        for(int i=0;n>0;i++) {
            int res = n - (i + 1);
            if( res >= 0) {
                n -= (i+1);
                count++;
            } else
                break;
        }
        return count;
    }
}