package us.supercheng.algorithm.problems.leetcode.searcha2dmatrixii;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return false;
        int LAST_COL = matrix[0].length-1,
                LAST_ROW = matrix.length - 1,
                currRow = 0,
                currCol = LAST_COL;
        while (true) {
            if (target == matrix[currRow][currCol])
                return true;
            else if (target < matrix[currRow][currCol])
                currCol--;
            else
                currRow++;
            if(currCol<0 || currRow>LAST_ROW)
                break;
        }
        return false;
    }
}