package us.supercheng.algorithm.problems.leetcode.decodexoredarray;

public class Solution {

    public int[] decode(int[] encoded, int first) {
        int len = encoded.length + 1;
        int[] ret = new int[len];
        ret[0] = first;

        for (int i=1; i<len; i++)
            ret[i] = encoded[i-1] ^ ret[i-1];

        return ret;
    }
}