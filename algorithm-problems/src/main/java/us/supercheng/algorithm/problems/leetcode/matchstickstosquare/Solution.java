package us.supercheng.algorithm.problems.leetcode.matchstickstosquare;

import java.util.Arrays;

class Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4)
            return false;

        long len = 0;
        for (int each : nums)
            len += each;

        if (len % 4 != 0)
            return false;

        Arrays.sort(nums);

        return this.helper(nums, nums.length-1, new long[4], len/4);
    }

    private boolean helper(int[] nums, int idx, long[] sides, long len) {
        if (idx==-1)
            return sides[0] == len && sides[1] == len && sides[2] == len && sides[3] == len;

        for (int j=0;j<4;j++) {
            sides[j] += nums[idx];
            if (sides[j] <= len && this.helper(nums, idx-1, sides, len))
                return true;
            sides[j] -= nums[idx];
        }
        return false;
    }

    private void echo(Object o) {
        System.out.println(o);
    }
}