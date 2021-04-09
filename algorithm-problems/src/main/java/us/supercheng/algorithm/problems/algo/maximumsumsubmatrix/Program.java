package us.supercheng.algorithm.problems.algo.maximumsumsubmatrix;

public class Program {

    // Time: O(m*n*size^2) Space: O(1)
    public int maximumSumSubmatrix_Solution1(int[][] matrix, int size) {
        Integer ret = null;

        for (int i=0, rowLen = matrix.length, colLen = matrix[0].length; i<=rowLen-size; i++) {
            int res = this.calArea(matrix, size, i, 0);
            if (ret == null || res > ret)
                ret = res;

            for (int j=1; j<=colLen-size; j++) {
                res = size > 1 ? this.updateArea(matrix, size, i, j, res) : matrix[i][j];
                if (ret == null || res > ret)
                    ret = res;
            }
        }

        return ret;
    }

    private int calArea(int[][] mat, int size, int r, int c) {
        int ret = 0;

        for (int i=0; i<size; i++)
            for (int j=0; j<size ; j++)
                ret += mat[i + r][j + c];

        return ret;
    }

    private int updateArea(int[][] mat, int size, int r, int c, int val) {
        for (int i=0; i<size; i++)
            val += (mat[r + i][c + size - 1] - mat[r + i][c - 1]);
        return val;
    }

    // Time: O(m*n) Space: O(m*n)
    public int maximumSumSubmatrix_Solution2(int[][] matrix, int size) {
        Integer ret = null;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[][] sum = new int[rowLen][colLen];

        sum[0][0] = matrix[0][0];
        for (int i=1; i<rowLen; i++)
            sum[i][0] = sum[i-1][0] + matrix[i][0];
        for (int i=1; i<colLen; i++)
            sum[0][i] += sum[0][i-1] + matrix[0][i];

        for (int i=1; i<rowLen; i++)
            for (int j=1; j<colLen; j++)
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + matrix[i][j] - sum[i - 1][j - 1];

        for (int i=size - 1; i<rowLen; i++)
            for (int j=size - 1 ; j<colLen; j++) {
                int res = sum[i][j];

                if (i - size > -1)
                    res -= sum[i - size][j];

                if (j - size > -1)
                    res -= sum[i][j - size];

                if ((i - size > -1) && (j - size > -1))
                    res += sum[i - size][j - size];

                if (ret == null || res > ret)
                    ret = res;
            }

        return ret;
    }
}
