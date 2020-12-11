package us.supercheng.algorithm.problems.leetcode.shufflethearray;

public class Solution {

    public int[] shuffle(int[] nums, int n) {
        int len = nums.length,
            pointer = 0;
        int[] ret = new int[len];

        for (int i=0; i<n; i++)
            for (int idx = i; idx<len; idx+=n)
                ret[pointer++] = nums[idx];

        return  ret;
    }

}
