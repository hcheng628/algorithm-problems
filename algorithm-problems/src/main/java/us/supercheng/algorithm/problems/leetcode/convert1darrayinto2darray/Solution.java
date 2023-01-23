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

}
