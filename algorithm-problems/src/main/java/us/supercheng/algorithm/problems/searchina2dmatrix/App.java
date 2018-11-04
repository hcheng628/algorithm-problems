package us.supercheng.algorithm.problems.searchina2dmatrix;

import java.util.Arrays;

public class App {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        if(matrix.length == 1) return Arrays.binarySearch(matrix[0], target) > -1;

        int [] indexArr = new int [matrix.length];
        for(int i=0;i<matrix.length;i++)
            indexArr[i] = matrix[i][0];
        int found = Arrays.binarySearch(indexArr, target);

        if(found > -1) return true;
        if(matrix[0].length == 1) return false;
        if(target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1]) return false;
        if(Arrays.binarySearch(matrix[-found-2], target) > -1) return true;
        return false;
    }
}
