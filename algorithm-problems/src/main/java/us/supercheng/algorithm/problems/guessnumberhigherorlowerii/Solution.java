package us.supercheng.algorithm.problems.guessnumberhigherorlowerii;

public class Solution {
    
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];

        for (int i=2;i<=n;i++)
            for (int j=i-1;j>=1;j--) {
                int min = Integer.MAX_VALUE;
                for (int k=j+1;k<i;k++)
                    min = Math.min(min, k + Math.max(dp[j][k-1], dp[k+1][i]));
                dp[j][i] = j+1 == i ? j : min;
            }

        return dp[1][n];
    }
}