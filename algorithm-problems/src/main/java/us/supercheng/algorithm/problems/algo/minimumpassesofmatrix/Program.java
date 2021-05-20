package us.supercheng.algorithm.problems.algo.minimumpassesofmatrix;

import java.util.*;

public class Program {

    // Time: O(m*n^2) Space: O(m*n)
    public int minimumPassesOfMatrix_Solution1(int[][] matrix) {
        int ret = 0;
        int changes = 1;
        boolean hasPos = false;
        boolean hasNeg = false;

        for (int rowLen = matrix.length, colLen = matrix[0].length; changes != 0; ) {
            changes = 0;
            hasNeg = false;
            boolean[][] flipped = new boolean[rowLen][colLen];

            for (int i=0; i<rowLen; i++)
                for (int j=0; j<colLen; j++) {
                    int num = matrix[i][j];
                    if (num > 0 && !flipped[i][j]) {
                        if (!hasPos)
                            hasPos = true;

                        if (i - 1 > -1 && matrix[i - 1][j] < 0) {
                            matrix[i - 1][j] = Math.abs(matrix[i - 1][j]);
                            flipped[i - 1][j] = true;
                            changes++;
                        }
                        if (i + 1 < rowLen && matrix[i + 1][j] < 0) {
                            matrix[i + 1][j] = Math.abs(matrix[i + 1][j]);
                            flipped[i + 1][j] = true;
                            changes++;
                        }

                        if (j - 1 > -1 && matrix[i][j - 1] < 0) {
                            matrix[i][j - 1] = Math.abs(matrix[i][j - 1]);
                            flipped[i][j - 1] = true;
                            changes++;
                        }

                        if (j + 1 < colLen && matrix[i][j + 1] < 0) {
                            matrix[i][j + 1] = Math.abs(matrix[i][j + 1]);
                            flipped[i][j + 1] = true;
                            changes++;
                        }
                    } else if (num < 0 && !hasNeg)
                        hasNeg = true;
                }

            if (changes != 0)
                ret++;
        }

        return hasPos && !hasNeg ? ret : -1;
    }

    // Time: O(m*n) Space: O(m*n)
    public int minimumPassesOfMatrix(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1)
            return -1;

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int ret = this.flip(matrix, rowLen, colLen, this.getPosNums(matrix, rowLen, colLen));
        return this.hasNegNum(matrix, rowLen, colLen) ? -1 : ret;
    }

    private int flip(int[][] mat, int rowLen, int colLen, List<int[]> posNums) {
        if (posNums == null || posNums.isEmpty())
            return 0;

        List<int[]> newPosNums = new ArrayList<>();
        for (int[] posNum : posNums) {
            int row = posNum[0];
            int col = posNum[1];

            if (row - 1 > -1 && mat[row - 1][col] < 0) {
                mat[row - 1][col] = Math.abs(mat[row - 1][col]);
                newPosNums.add(new int[]{row - 1, col});
            }

            if (row + 1 < rowLen && mat[row + 1][col] < 0) {
                mat[row + 1][col] = Math.abs(mat[row + 1][col]);
                newPosNums.add(new int[]{row + 1, col});
            }

            if (col - 1 > -1 && mat[row][col - 1] < 0) {
                mat[row][col - 1] = Math.abs(mat[row][col - 1]);
                newPosNums.add(new int[]{row, col - 1});
            }

            if (col + 1 < colLen && mat[row][col + 1] < 0) {
                mat[row][col + 1] = Math.abs(mat[row][col + 1]);
                newPosNums.add(new int[]{row, col + 1});
            }
        }

        return newPosNums.isEmpty() ? 0 : 1 + this.flip(mat, rowLen, colLen, newPosNums);
    }

    private boolean hasNegNum(int[][] mat, int rowLen, int colLen) {
        for (int[] m : mat)
            for (int mm : m)
                if (mm < 0)
                    return true;
        return false;
    }

    private List<int[]> getPosNums(int[][] mat, int rowLen, int colLen) {
        List<int[]> ret = new ArrayList<>();
        for (int i=0; i<rowLen; i++)
            for (int j=0; j<colLen; j++)
                if (mat[i][j] > 0)
                    ret.add(new int[]{i, j});
        return ret;
    }

}
