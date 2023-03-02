package us.supercheng.algorithm.problems.leetcode.maximumcountofpositiveintegerandnegativeinteger;

import java.util.Arrays;

class Solution {

    public int maximumCount(int[] nums) {
        int idx = Arrays.binarySearch(nums, 0, nums.length, 0);

        if (idx < 0)
            return Math.max(nums.length - Math.abs(idx + 1), Math.abs(idx + 1));

        int left = idx;
        int right = idx;

        while (left > -1 && nums[left] == 0)
            left--;
        while (right < nums.length && nums[right] == 0)
            right++;

        return Math.max(left + 1, nums.length - right);
    }

}
