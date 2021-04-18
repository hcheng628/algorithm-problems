package us.supercheng.algorithm.problems.leetcode.minimumoperationstomakethearrayincreasing;

public class Solution {

    public int minOperations(int[] nums) {
        int ret = 0;

        for (int i=1, len=nums.length; i<len; i++)
            if (nums[i - 1] >= nums[i]) {
                int increase = nums[i - 1] - nums[i] + 1;
                nums[i] += increase;
                ret += increase;
            }

        return ret;
    }

}
