package us.supercheng.algorithm.problems.leetcode.maximumnumberofpairsinarray;

class Solution {

    public int[] numberOfPairs(int[] nums) {
        int[] ret = new int[2];
        int[] count = new int[101];

        for (int n : nums)
            count[n]++;

        for (int i = 0; i < 101; i++)
            if (count[i] != 0) {
                ret[0] += count[i] / 2;
                ret[1] += count[i] % 2;
            }

        return ret;
    }

}
