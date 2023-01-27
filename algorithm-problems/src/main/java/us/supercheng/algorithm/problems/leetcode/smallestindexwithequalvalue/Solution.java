package us.supercheng.algorithm.problems.leetcode.smallestindexwithequalvalue;

public class Solution {

    public int smallestEqual(int[] nums) {
        if (nums == null)
            return -1;

        for (int i = 0, len = nums.length; i < len; i++)
            if (i % 10 == nums[i])
                return i;

        return -1;
    }

}
