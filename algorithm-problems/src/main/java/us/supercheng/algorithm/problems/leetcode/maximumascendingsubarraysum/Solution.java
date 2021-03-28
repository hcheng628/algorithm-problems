package us.supercheng.algorithm.problems.leetcode.maximumascendingsubarraysum;

public class Solution {

    public int maxAscendingSum(int[] nums) {
        int ret = nums[0];

        for (int i=0, len=nums.length; i<len - 1; i++) {
            int sum = nums[i];

            while (i + 1<len && nums[i] < nums[i + 1])
                sum += nums[++i];

            ret = Math.max(sum, ret);
        }

        return ret;
    }

}