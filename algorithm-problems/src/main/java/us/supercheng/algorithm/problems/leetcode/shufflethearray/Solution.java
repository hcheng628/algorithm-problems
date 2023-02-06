package us.supercheng.algorithm.problems.leetcode.shufflethearray;

public class Solution {

    public int[] shuffle(int[] nums, int n) {
        if (nums == null)
            return new int[0];

        int[] ret = new int[n * 2];
        for (int idx = 0, i = 0, ii = n; i < n; i++, ii++) {
            ret[idx++] = nums[i];
            ret[idx++] = nums[ii];
        }

        return ret;
    }

}
