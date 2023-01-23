package us.supercheng.algorithm.problems.leetcode.convert1darrayinto2darray;

public class Solution {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original == null || original.length != m * n)
            return new int[0][0];

        int[][] ret = new int[m][n];
        int idx = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                ret[i][j] = original[idx++];

        return ret;
    }

    public int[][] construct2DArrayOPT(int[] original, int m, int n) {
        if (original == null || original.length != m * n)
            return new int[0][0];

        int[][] ret = new int[m][n];

        for (int i = 0; i < m; i++)
            System.arraycopy(original, i * n, ret[i], 0, n);

        return ret;
    }

}
