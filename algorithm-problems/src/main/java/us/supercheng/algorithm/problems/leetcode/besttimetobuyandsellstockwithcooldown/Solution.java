package us.supercheng.algorithm.problems.leetcode.besttimetobuyandsellstockwithcooldown;

public class Solution {
    public int maxProfit(int[] prices) {
        int [] buy = new int [prices.length+1],
                sell = new int [prices.length+1],
                rest = new int [prices.length+1];

        buy[0] = Integer.MIN_VALUE;
        sell[0] = 0;
        rest[0] = 0;

        for (int i=1;i<=prices.length;i++) {
            buy[i] = Math.max(buy[i-1], rest[i-1] - prices[i-1]);
            //sell[i] = Math.max(rest[i-1] - prices[i], buy[i-1] - prices[i]);
            sell[i] = buy[i-1] + prices[i-1];
            rest[i] = Math.max(sell[i-1], rest[i-1]);
        }

        return Math.max(sell[prices.length], rest[prices.length]);
    }
}