package us.supercheng.algorithm.problems.deleteandearn;

public class Solution {

    public int deleteAndEarn(int[] nums) {
        int[] bucket = new int[10001];
        int[] dp = new int [10001];

        for (int num : nums)
            bucket[num] += num;

        dp[1] = bucket[1];
        for (int i=2;i<10001;i++)
            dp[i] = Math.max(bucket[i] + dp[i-2], dp[i-1]);

        return dp[10000];
    }

    public int deleteAndEarnDPOpt(int[] nums) {
        int[] bucket = new int[10001];
        for (int num : nums)
            bucket[num] += num;

        int skip = 0,
            take = 0;

        for (int i=0;i<10001;i++)
            if (bucket[i] > 0) {
                int res = skip + bucket[i];
                skip = Math.max(skip, take);
                take = res;
            } else
                skip = take = Math.max(skip, take);

        return Math.max(skip, take);
    }

    public int deleteAndEarnFastSkip(int[] nums) {
        int[] bucket = new int[10001];
        for (int num : nums)
            bucket[num] += num;

        int skip = 0,
            take = 0,
            prevIdx = -1;

        for (int i=0;i<10001;i++)
            if (bucket[i] > 0) {
                int max = Math.max(take, skip);
                take = i-1 == prevIdx ? bucket[i] + skip : bucket[i] + max;
                skip = max;
                prevIdx = i;
            }

        return Math.max(skip, take);
    }
}