package us.supercheng.algorithm.problems.leetcode.besttimetobuyandsellstockwithtransactionfee;

public class Solution {

    public int maxProfitDP(int[] prices, int fee) {
        if (prices == null || prices.length < 2)
            return 0;

        int dp[][] = new int[prices.length][2];
        int len = prices.length;

        // init
        // dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // trans
        for (int i=1;i<len;i++) {
            dp[i][0] = Math.max(dp[i-1][0], prices[i] + dp[i-1][1] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return dp[len-1][0];
    }

    public int maxProfitOpt(int[] prices, int fee) {
        if (prices == null || prices.length < 2)
            return 0;

        // init
        int len = prices.length,
                buy = -prices[0],
                hold = 0;

        // trans
        for (int i=1;i<len;i++) {
            int temp = hold;
            hold = Math.max(hold, prices[i] + buy - fee);
            buy = Math.max(buy, temp - prices[i]);
        }

        return hold;
    }
}