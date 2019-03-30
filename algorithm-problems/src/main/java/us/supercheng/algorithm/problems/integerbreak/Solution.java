package us.supercheng.algorithm.problems.integerbreak;

import java.util.Arrays;

class Solution {
    public int integerBreak(int n) {
        if (n < 4)
            return n - 1;

        int ret = 1;

        while (n > 4) {
            n -= 3;
            ret *= 3;
        }

        return ret * n;
    }

    Integer dp [];

    public int integerBreakRec(int n) {
        this.dp = new Integer [n+1];
        this.dp[1] = 1; // dfs end condition
        return this.dfs(n);
    }

    public int dfs(int n) {
        if (this.dp[n] != null)
            return this.dp[n];

        this.dp[n] = -1;
        for (int i=1;i<n;i++)
            this.dp[n] = this.max3(i * (n-i), i*this.dfs(n-i), this.dp[n]);

        return this.dp[n];
    }

    private int max3(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public int integerBreak2(int n) {
        this.dp = new Integer [n+1];
        Arrays.fill(this.dp, -1);

        this.dp[1] = 1; // init

        for (int i=2;i<=n;i++)
            for (int j=1;j<i;j++)
                this.dp[i] = this.max3(j*(i-j), j*this.dp[i-j], this.dp[i]);

        return this.dp[n];
    }
}