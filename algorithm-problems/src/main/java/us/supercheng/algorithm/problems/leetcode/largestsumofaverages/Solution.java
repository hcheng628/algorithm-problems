package us.supercheng.algorithm.problems.leetcode.largestsumofaverages;

public class Solution {
    int len = 0;
    double[][] memo;
    double[] sum;

    public double largestSumOfAveragesMemo(int[] A, int K) {
        len = A.length;
        sum = new double[len];
        this.memo = new double[K + 1][len];

        sum[0] = A[0];
        for(int i = 1; i < len; i++)
            sum[i] = sum[i-1] + A[i];

        return helper(A, K, 0);
    }

    public double helper(int[] A, int k, int idx){
        if(k == 1)
            return (sum[len-1] - sum[idx] + A[idx]) / (len - idx);

        if(memo[k][idx] != 0)
            return memo[k][idx];

        for(int i=idx;i<=len-k;i++)
            memo[k][idx] = Math.max(memo[k][idx], (sum[i] - sum[idx] + A[idx]) / (i-idx +1) + helper(A, k-1, i+1));

        return memo[k][idx];
    }

    public double largestSumOfAverages(int[] A, int K) {
        if (A == null || A.length < 1 || K < 1)
            return 0;

        int len = A.length;
        double[] sum = new double[len+1];
        double[][] dp = new double[K+1][len+1];

        // init sum + dp[1]
        for (int i=1;i<=len;i++) {
            sum[i] = A[i-1] + sum[i-1];
            dp[1][i] = sum[i] / i;
        }

        for (int count=2;count<=K;count++)
            for (int i=count;i<=len;i++)
                for (int j=count-1;j<i;j++)
                    dp[count][i] = Math.max(dp[count][i], dp[count-1][j] + ((sum[i] - sum[j]) / (i-j)));

        return dp[K][len];
    }
}