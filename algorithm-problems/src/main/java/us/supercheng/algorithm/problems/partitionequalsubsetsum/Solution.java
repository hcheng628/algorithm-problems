package us.supercheng.algorithm.problems.partitionequalsubsetsum;

class Solution {

    Boolean [][] memo;

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums)
            sum += num;

        if (sum % 2 != 0)
            return false;

        this.memo = new Boolean [nums.length][sum+1];
        return this.search(nums, nums.length-1, sum/2);
    }

    private boolean search(int[] nums, int idx, int target) {
        if (idx <0 || target < 0)
            return false;
        else if (target == 0)
            return true;

        if (this.memo[idx][target] != null)
            return this.memo[idx][target];

        this.memo[idx][target] = this.search(nums, idx-1, target) ||
                this.search(nums, idx-1, target - nums[idx]);

        return this.memo[idx][target];
    }
}