package us.supercheng.algorithm.problems.dominoandtrominotiling;

public class Solution {

    public int numTilings(int N) {
        if (N == 1) {
            return 1;
        }
        long[][] dp = new long[N+1][2];

        //init
        dp[1][0] = 1;
        dp[2][0] = 2;
        dp[2][1] = 1;

        for (int i=3;i<=N;i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-2][0] + 2*dp[i-1][1]) % 1000000007;
            dp[i][1] = (dp[i-2][0] + dp[i-1][1]) % 1000000007;
        }

        return (int) dp[N][0];
    }
}