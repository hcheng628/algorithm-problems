package us.supercheng.algorithm.problems.leetcode.checkifeveryrowandcolumncontainsallnumbers;

class Solution {

    public boolean checkValid(int[][] matrix) {
        return this.isLine(matrix, true) && this.isLine(matrix, false);
    }

    public boolean isLine(int[][] mat, boolean isRow) {
        for (int i = 0, len = mat.length; i < len; i++) {
            boolean[] set = new boolean[len + 1];
            for (int j = 0; j < len; j++) {
                int num = isRow ? mat[i][j] : mat[j][i];
                if (set[num])
                    return false;
                set[num] = true;
            }
        }

        return true;
    }

}
