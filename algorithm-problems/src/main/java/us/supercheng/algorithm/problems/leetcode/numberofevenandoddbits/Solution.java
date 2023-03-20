package us.supercheng.algorithm.problems.leetcode.numberofevenandoddbits;

class Solution {
    public int[] evenOddBit(int n) {
        int[] ret = new int[2];

        for (boolean firstIdx = true; n != 0; n >>= 1, firstIdx = !firstIdx)
            if ((n & 1) == 1)
                ret[firstIdx ? 0 : 1]++;

        return ret;
    }
}
