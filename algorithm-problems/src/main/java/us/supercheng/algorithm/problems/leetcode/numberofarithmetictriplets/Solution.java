package us.supercheng.algorithm.problems.leetcode.numberofarithmetictriplets;

import java.util.Arrays;

class Solution {

    public int arithmeticTriplets(int[] nums, int diff) {
        int ret = 0;

        for (int i = 0, len = nums.length; i < len - 1; i++)
            if (Arrays.binarySearch(nums, 0, i, nums[i] - diff) > -1 &&
                    Arrays.binarySearch(nums, i + 1, len, nums[i] + diff) > -1)
                ret++;

        return ret;
    }

}
