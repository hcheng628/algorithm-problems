package us.supercheng.algorithm.problems.houserobberii;

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
}