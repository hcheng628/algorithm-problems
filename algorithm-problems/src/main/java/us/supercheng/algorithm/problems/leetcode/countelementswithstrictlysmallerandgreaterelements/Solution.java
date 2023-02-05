package us.supercheng.algorithm.problems.leetcode.countelementswithstrictlysmallerandgreaterelements;

class Solution {

    public int countElements(int[] nums) {
        if (nums == null || nums.length < 3)
            return 0;

        int ret = 0;
        int min = nums[0];
        int max = nums[0];

        for (int n : nums) {
            min = Math.min(n, min);
            max = Math.max(n, max);
        }

        for (int n : nums)
            if (min < n && n < max)
                ret++;

        return ret;
    }

}
