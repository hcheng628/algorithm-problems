package us.supercheng.algorithm.problems.leetcode.houserobberii;

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        else if(nums.length == 1)
            return nums[0];
        else if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        return Math.max(robHelper(nums, 1, nums.length-1), robHelper(nums, 0, nums.length-2));
    }

    private int robHelper(int [] nums, int start, int end) {
        int [] dp = new int [end - start + 2];
        dp[start] = nums[start];
        dp[start+1] = Math.max(dp[start], nums[start+1]);
        for(int i=start+2;i<=end;i++)
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        return dp[start == 0 ? dp.length -2 : dp.length-1];
    }

    /* Memo Rec + DP */

    Integer[][] memo;

    public int robRec(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        this.memo = new Integer[2][nums.length];

        return Math.max(this.robRec(nums, nums.length-1, 1),
                this.robRec(nums, nums.length-2, 0));
    }

    private int robRec(int[] nums, int idx, int start) {
        if (idx < start)
            return 0;
        if (this.memo[start][idx] != null)
            return this.memo[start][idx];
        this.memo[start][idx] = Math.max(nums[idx] + this.robRec(nums, idx-2, start), this.robRec(nums, idx-1, start));
        return this.memo[start][idx];
    }

    public int robDP(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        return Math.max(this.robDP(nums, 0, nums.length-1), this.robDP(nums, 1, nums.length));
    }

    private int robDP(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);

        for (int i=start+2;i<end;i++)
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        return dp[end-1];
    }
}