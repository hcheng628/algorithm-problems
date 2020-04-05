package us.supercheng.algorithm.problems.new21game;

public class Solution {

    public double new21Game(int N, int K, int W) {
        //return this.dfs(N, K, W, 0);
        double ret = 0.0;
        double[] dp = new double[N+1];
        dp[0] = 1.0;

        for (int i=1; i<=N; i++) {
            if (i-1 < K)
                ret += dp[i-1];

            if (i-W-1 > -1)
                ret -= dp[i-W-1];

            dp[i] = ret * 1/W;
        }

        ret = 0.0;
        for (int i=K;i<=N;i++)
            ret += dp[i];

        return ret;
    }

    private double dfs(int N, int K, int W, int curr) {
        if (curr >= K)
            return curr > N ? 0.0 : 1.0;

        double ret = 0.0;
        for (int i=1;i<=W;i++)
            ret += this.dfs(N, K, W, i+curr) * 1/W;

        return ret;
    }
}