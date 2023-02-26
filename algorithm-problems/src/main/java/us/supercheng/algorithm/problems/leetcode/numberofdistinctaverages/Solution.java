package us.supercheng.algorithm.problems.leetcode.numberofdistinctaverages;

import java.util.Arrays;

class Solution {

    public int distinctAverages(int[] nums) {
        int ret = 0;
        int[] uniqueCount = new int[201];
        Arrays.sort(nums);

        for (int left = 0, right = nums.length - 1; left < right; left++, right--)
            if (uniqueCount[nums[left] + nums[right]]++ == 0)
                ret++;

        return ret;
    }

}
