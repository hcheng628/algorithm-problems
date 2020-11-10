package us.supercheng.algorithm.problems.minimumfallingpathsum;

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
        int rowL = A.length,
                colL = A[0].length,
                ret = Integer.MAX_VALUE;

        if (rowL == 1 && colL == 1)
            return A[0][0];

        int[][] dp = new int[rowL][colL];

        for (int c=0; c<colL; c++)
            dp[0][c] = A[0][c];

        for (int r=1; r<rowL; r++)
            for (int c=0; c<colL; c++) {
                int res = dp[r-1][c];

                if (c-1>-1 && dp[r-1][c-1] < res)
                    res = dp[r-1][c-1];

                if (c + 1 < colL && dp[r-1][c+1] < res)
                    res = dp[r-1][c+1];

                dp[r][c] = res + A[r][c];

                if (r == rowL - 1 && dp[r][c] < ret)
                    ret = dp[r][c];
            }

        return ret;
    }
}