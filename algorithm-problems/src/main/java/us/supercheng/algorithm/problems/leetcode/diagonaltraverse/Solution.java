package us.supercheng.algorithm.problems.leetcode.diagonaltraverse;

class Solution {

    int idx;

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length < 1)
            return new int[0];
        else if (matrix.length < 2)
            return matrix[0];

        this.idx = 0;
        int ROW_LEN = matrix.length,
                COL_LEN = matrix[0].length;
        int[] ret = new int [ROW_LEN * COL_LEN];
        this.helper(matrix, 0, 0, true, ret, ROW_LEN, COL_LEN);

        return ret;
    }

    private void helper(int[][] matrix, int x, int y, boolean isUpRight, int[] ret, int ROW_LEN, int COL_LEN) {
        if (x < 0 || x >= ROW_LEN || y < 0 || y >= COL_LEN)
            return;

        ret[this.idx++] = matrix[x][y];

        if (isUpRight)
            if (y+1 < COL_LEN && x-1 >= 0)
                this.helper(matrix, x-1, y+1, true, ret, ROW_LEN, COL_LEN);
            else
            if (y+1 < COL_LEN)
                this.helper(matrix, x, y+1, false, ret, ROW_LEN, COL_LEN);
            else
                this.helper(matrix, x+1, y, false, ret, ROW_LEN, COL_LEN);
        else
        if (x+1 < ROW_LEN && y-1 > -1)
            this.helper(matrix, x+1, y-1, false, ret, ROW_LEN, COL_LEN);
        else
        if (x+1 < ROW_LEN)
            this.helper(matrix, x+1, y, true, ret, ROW_LEN, COL_LEN);
        else
            this.helper(matrix, x, y+1, true, ret, ROW_LEN, COL_LEN);
    }
}