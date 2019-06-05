package us.supercheng.algorithm.problems.minimummovestoequalarrayelementsii;

import java.util.Arrays;

class Solution {

    public int minMoves2(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;

        Arrays.sort(nums);
        int len = nums.length, mid = len/2;

        return this.calMoves(nums, len, nums[mid], len % 2 == 0 ? null : nums[mid-1]);
    }

    private int calMoves(int[] nums, int len, int valA, Integer valB) {
        int retA = 0, retB = 0;

        for (int i=0;i<len;i++) {
            retA += Math.abs(valA - nums[i]);
            if (valB != null)
                retB += Math.abs(valB - nums[i]);
        }
        return valB == null || retA < retB ? retA : retB;
    }
}