package us.supercheng.algorithm.problems.toeplitzmatrix;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        PrintHelper.echoLn(new App().isToeplitzMatrix(matrix));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=matrix.length-1;i>=0;i--)
            for(int j=0;j<matrix[i].length;j++)
                if(!this.helper(matrix, i, j, matrix[i][j]))
                    return false;
        return true;
    }

    private boolean helper(int[][] matrix, int row, int col, int val) {
        if(row <0 || col < 0)
            return true;
        if(matrix[row][col] != val)
            return false;
        return helper(matrix, row -1, col -1, val);
    }

    public boolean isToeplitzMatrix1(int[][] matrix) {
        for(int i=0;i<matrix.length-1;i++)
            for(int j=0;j<matrix[i].length-1;j++)
                if(matrix[i][j] != matrix[i+1][j+1])
                    return false;
        return true;
    }
}