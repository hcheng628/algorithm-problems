package us.supercheng.algorithm.problems.leetcode.largestlocalvaluesinamatrix;

class Solution {

    public int[][] largestLocal(int[][] grid) {
        int len = grid.length;
        int[][] ret = new int[len - 2][len - 2];

        for (int i = 0; i < len - 2; i++)
            for (int j = 0; j < len - 2; j++)
                ret[i][j] = this.maxVal(grid, i, j);

        return ret;
    }

    private int maxVal(int[][] grid, int i, int j) {
        int ret = grid[i][j];

        for (int ii = 0; ii < 3; ii++)
            for (int jj = 0; jj < 3; jj++)
                ret = Math.max(grid[ii + i][jj + j], ret);

        return ret;
    }

}
