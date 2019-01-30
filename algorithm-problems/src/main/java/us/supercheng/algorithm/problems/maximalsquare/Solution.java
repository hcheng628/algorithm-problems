package us.supercheng.algorithm.problems.maximalsquare;

class Solution {

    public int maximalSquare(char[][] matrix) {
        int ret = 0;
        for (int row=0;row<matrix.length;row++)
            for (int col=0;col<matrix[row].length;col++) {
                boolean flag = true;
                if(matrix[row][col] == '1') {
                    int res = 1,
                            remain = Math.min(matrix.length - row, matrix[row].length - col);
                    for(int k=1;k<remain;k++) {
                        for(int nextRow=row;nextRow<=row+k;nextRow++) {
                            if(matrix[nextRow][col+k] != '1') {
                                flag = false;
                                break;
                            }
                        }
                        if(!flag)
                            break;
                        for(int nextCol=col;nextCol<col+k;nextCol++) {
                            if(matrix[row+k][nextCol] != '1') {
                                flag = false;
                                break;
                            }
                        }
                        if(!flag)
                            break;
                        res++;
                    }
                    if(res > ret)
                        ret = res;
                }
            }
        return ret * ret;
    }

    public int maximalSquareDP(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int ret = 0;
        int [][] dp = new int [matrix.length][matrix[0].length];

        for (int i=0;i<matrix.length;i++) {
            dp[i][0] = matrix[i][0] - '0';
            ret = Math.max(ret, dp[i][0]);
        }

        for (int i=0;i<matrix[0].length;i++) {
            dp[0][i] = matrix[0][i] - '0';
            ret = Math.max(ret, dp[0][i]);
        }


        for (int i=1;i<matrix.length;i++)
            for (int j=1;j<matrix[i].length;j++)
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    ret = Math.max(ret, dp[i][j]);
                }

        return ret * ret;
    }
}