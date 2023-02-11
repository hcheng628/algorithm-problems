package us.supercheng.algorithm.problems.leetcode.findclosestnumbertozero;

import java.util.Arrays;

class Solution {

    public int findClosestNumberBS(int[] nums) {
        Arrays.sort(nums);
        int idx = Arrays.binarySearch(nums, 0);

        if (idx > - 1)
            return nums[idx];

        idx = Math.abs(idx + 1);
        if (idx - 1 < 0)
            return nums[idx];
        else if (idx >= nums.length)
            return nums[nums.length - 1];

        return Math.abs(nums[idx - 1]) < Math.abs(nums[idx]) ? nums[idx - 1] : nums[idx];
    }

    public int findClosestNumber(int[] nums) {
        int[] info = new int[]{Math.abs(nums[0]), 0};

        for (int i = 0, len = nums.length; i < len; i++) {
            int diff = Math.abs(nums[i]);
            if (diff < info[0] || nums[i] == info[0])
                info = new int[]{diff, i};
        }

        return nums[info[1]];
    }

}
