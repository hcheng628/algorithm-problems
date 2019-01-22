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
}