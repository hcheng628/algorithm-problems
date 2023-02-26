package us.supercheng.algorithm.problems.leetcode.applyoperationstoanarray;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {

    public int[] applyOperations(int[] nums) {
        int len = nums.length;
        int zeroStart = 0;

        for (int i = 0; i < len - 1; i++)
            if (i < len - 1 && nums[i] == nums[i + 1]) {
                nums[i] <<= 1;
                nums[i + 1] = 0;
            }

        for (int i = 0; i < len; i++)
            if (nums[i] != 0)
                nums[zeroStart++] = nums[i];

        Arrays.fill(nums, zeroStart, len, 0);

        return nums;
    }

}