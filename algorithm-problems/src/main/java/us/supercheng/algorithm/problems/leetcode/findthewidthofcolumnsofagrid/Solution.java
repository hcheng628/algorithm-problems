package us.supercheng.algorithm.problems.leetcode.findthewidthofcolumnsofagrid;

class Solution {

    public int[] findColumnWidth(int[][] grid) {
        int cLen = cLen = grid[0].length;
        int[] ret = new int[cLen];

        for (int i = 0, c = 0; c < cLen; i++, c++)
            for (int[] ints : grid)
                ret[i] = Math.max(intLen(ints[c]), ret[i]);

        return ret;
    }

    private int intLen(int n) {
        if (n == 0)
            return 1;

        int ret = n < 0 ? 1 : 0;

        for (int nn = Math.abs(n); nn > 0; nn /= 10)
            ret++;

        return ret;
    }

}
