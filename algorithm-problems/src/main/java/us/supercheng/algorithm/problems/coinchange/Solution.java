package us.supercheng.algorithm.problems.coinchange;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = amount+1;
        int [] changeDP = new int [len];

        for (int i=1;i<len;i++) {
            changeDP[i] = len;
            for (int coin=coins.length-1;coin>=0;coin--)
                if (i - coins[coin] >= 0)
                    changeDP[i] = Math.min(changeDP[i-coins[coin]]+1, changeDP[i]);
        }
        return changeDP[amount] == len ? -1 : changeDP[amount];
    }
}