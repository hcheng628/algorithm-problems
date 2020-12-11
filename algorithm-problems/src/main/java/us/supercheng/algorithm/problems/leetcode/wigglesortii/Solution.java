package us.supercheng.algorithm.problems.leetcode.wigglesortii;

import java.util.Arrays;

public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2)
            return;

        Arrays.sort(nums);
        int left = (nums.length-1)/2, right = nums.length-1;
        int [] copy = new int [nums.length];

        for (int i=0;i<nums.length;i++)
            copy[i] = (i & 1) == 0 ? nums[left--] : nums[right--];

        System.arraycopy(copy, 0, nums, 0, nums.length);
    }
}