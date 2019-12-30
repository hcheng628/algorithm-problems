package us.supercheng.algorithm.problems.deleteandearn;

public class Solution {

    public int deleteAndEarn(int[] nums) {
        int[] bucket = new int[10001];
        int[] dp = new int [10001];

        for (int n : nums)
            bucket[n]++;

        dp[1] = bucket[1];
        for (int i=2;i<10001;i++)
            dp[i] = Math.max(i*bucket[i] + dp[i-2], dp[i-1]);

        return dp[10000];
    }
}