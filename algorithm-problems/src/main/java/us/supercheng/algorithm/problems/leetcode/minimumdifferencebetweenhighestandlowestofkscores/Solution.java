package us.supercheng.algorithm.problems.leetcode.minimumdifferencebetweenhighestandlowestofkscores;

import java.util.Arrays;

public class Solution {

    public int minimumDifference(int[] nums, int k) {
        if (nums == null || k < 1)
            return 0;

        Arrays.sort(nums);
        int ret = nums[k - 1] - nums[0];

        for (int i = k - 1; i < nums.length; i++)
            ret = Math.min(nums[i] - nums[i - k + 1], ret);

        return ret;
    }

}
