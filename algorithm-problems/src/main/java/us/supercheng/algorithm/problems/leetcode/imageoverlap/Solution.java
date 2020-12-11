package us.supercheng.algorithm.problems.leetcode.imageoverlap;

public class Solution {

    public int largestOverlap(int[][] A, int[][] B) {
        int ret = 0;

        for (int len=A.length, i=-len+1;i<len;i++)
            for (int j=-len+1;j<len;j++)
                ret = Math.max(this.count(A, B, i, j, len), ret);

        return ret;
    }

    private int count(int[][] A, int[][] B, int x, int y, int len) {
        int ret = 0;

        for (int i=0;i<len;i++)
            for (int j=0;j<len;j++)
                if ((x + i > -1 && x + i < len) && (y + j > -1 && y + j < len) && A[i][j] * B[i+x][j+y] == 1)
                    ret++;

        return ret;
    }
}