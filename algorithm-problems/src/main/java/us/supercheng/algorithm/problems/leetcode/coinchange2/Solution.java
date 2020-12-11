package us.supercheng.algorithm.problems.leetcode.coinchange2;

public class Solution {

    public int change2D(int amount, int[] coins) {
        if (coins == null || coins.length < 1)
            return amount == 0 ? 1 : 0;

        int[][] dp = new int[amount+1][coins.length];

        for (int val=0;val<=amount;val++)
            if (val % coins[0] == 0)
                dp[val][0] = 1;

        for(int i=1;i<coins.length;i++) {
            dp[0][i] = 1;
            for (int val=1;val<=amount;val++) {
                int res = val - coins[i];
                dp[val][i] += dp[val][i-1];
                if (res >= 0)
                    dp[val][i] += dp[res][i];
            }
        }
        return dp[amount][coins.length-1];
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins)
            for (int val=coin;val<=amount;val++)
                dp[val] += dp[val - coin];

        return dp[amount];
    }
}