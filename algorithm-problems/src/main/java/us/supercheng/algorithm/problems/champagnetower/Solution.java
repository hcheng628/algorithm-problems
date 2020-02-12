package us.supercheng.algorithm.problems.champagnetower;

public class Solution {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[100][100];

        dp[0][0] = poured;

        for (int i=0;i<99;i++)
            for (int j=0;j<=i;j++)
                if (dp[i][j] > 1.0) {
                    int next = i+1;
                    double amt = (dp[i][j] - 1.0) / 2;
                    dp[next][j] += amt;
                    dp[next][j+1] += amt;
                }

        return Math.min(dp[query_row][query_glass], 1);
    }
}