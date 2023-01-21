package us.supercheng.algorithm.problems.leetcode.maximumdifferencebetweenincreasingelements;

public class Solution {

    public int maximumDifference(int[] nums) {
        if (nums == null || nums.length < 2)
            return -1;

        int ret = -1;

        for (int i = 0, j = i + 1, len = nums.length; j < len; j++)
            if (nums[i] >= nums[j])
                i = j;
            else
                ret = Math.max(nums[j] - nums[i], ret);

        return ret > 0 ? ret : -1;
    }

}
