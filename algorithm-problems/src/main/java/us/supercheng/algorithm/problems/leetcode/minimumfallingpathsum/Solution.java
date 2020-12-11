package us.supercheng.algorithm.problems.leetcode.minimumfallingpathsum;

public class Solution {

    private Integer[][] memo;

    public int minFallingPathSum(int[][] A) {
        int len = A.length,
                cLen = A[0].length;
        Integer ret = null;
        this.memo = new Integer[len][cLen];

        for (int i=0; i<cLen; i++)
            this.memo[0][i] = A[0][i];

        for (int i=0, lastRow=len-1; i<cLen; i++) {
            int res = this.helper(A, cLen, lastRow, i);
            if (ret == null || res < ret)
                ret = res;
        }

        return ret;
    }

    private int helper(int[][] A, int cLen, int row, int col) {
        if (this.memo[row][col] != null)
            return this.memo[row][col];

        Integer preCurr = preCurr = this.helper(A, cLen, row-1, col),
                prePre = null,
                preNext = null;

        if (col - 1 > -1)
            prePre = this.helper(A, cLen, row-1, col-1);

        if (col + 1 < cLen)
            preNext = this.helper(A, cLen, row-1, col+1);

        if (prePre != null && prePre < preCurr)
            preCurr = prePre;

        if (preNext != null && preNext < preCurr)
            preCurr = preNext;

        return this.memo[row][col] = A[row][col] + preCurr;
    }

    public int minFallingPathSumDP(int[][] A) {
        int rLen = A.length,
                cLen = A[0].length;

        if (rLen == 1 && cLen == 1)
            return A[0][0];

        int[] dp = new int[cLen];
        Integer ret = null;


        for (int i=0; i<cLen; i++)
            dp[i] = A[0][i];

        for (int i=1; i<rLen; i++) {
            int[] temp = new int[cLen];

            for (int j=0; j<cLen; j++) {
                int res = dp[j];

                if (j-1 > -1 && dp[j-1] < res)
                    res = dp[j-1];

                if (j+1 < cLen && dp[j+1] < res)
                    res = dp[j+1];

                temp[j] = res + A[i][j];
                if (i == rLen - 1 && (ret == null || ret > temp[j]))
                    ret = temp[j];
            }
            dp = temp;
        }

        return ret;
    }
}