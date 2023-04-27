package us.supercheng.algorithm.problems.leetcode.rowwithmaximumones;

class Solution {

    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] ret = new int[]{-1, -1};

        for (int r = 0, rLen = mat.length, cLen = mat[0].length; r < rLen; r++) {
            int count = 0;
            for (int c = 0; c < cLen; c++)
                if (mat[r][c] == 1)
                    count++;

            if (count > ret[1])
                ret = new int[]{r, count};
        }

        return ret;
    }

}
