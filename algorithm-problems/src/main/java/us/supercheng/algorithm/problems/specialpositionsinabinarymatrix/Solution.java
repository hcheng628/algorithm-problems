package us.supercheng.algorithm.problems.specialpositionsinabinarymatrix;

public class Solution {

    public int numSpecial(int[][] mat) {
        int ret = 0;
        boolean[] rowSet = new boolean[101],
                  colSet = new boolean[101];

        for (int i=0, ROW=mat.length; i<ROW; i++)
            if (!rowSet[i])
                for (int j=0, COL=mat[i].length; j<COL; j++)
                    if (!colSet[j])
                        if (mat[i][j] == 1 && this.checkRow(ROW, mat, i, j) && this.checkCol(COL, mat, i, j)) {
                            ret++;
                            rowSet[i] = true;
                            colSet[j] = true;
                        }

        return ret;
    }

    private boolean checkRow(int ROW, int[][] mat, int r, int c) {
        for (int i=r-1; i>-1; i--)
            if (mat[i][c] == 1)
                return false;

        for (int i=r+1; i<ROW; i++)
            if (mat[i][c] == 1)
                return false;
        return true;
    }

    private boolean checkCol(int COL, int[][] mat, int r, int c) {
        for (int i=c-1; i>-1; i--)
            if (mat[r][i] == 1)
                return false;
        for (int i=c+1; i<COL; i++)
            if (mat[r][i] == 1)
                return false;
        return true;
    }
}