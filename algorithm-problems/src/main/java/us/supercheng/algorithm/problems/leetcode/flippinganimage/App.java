package us.supercheng.algorithm.problems.leetcode.flippinganimage;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int [][] A = {{1,1,0},{1,0,1},{0,0,0}};
        for(int [] each : new App().flipAndInvertImage(A)) {
            for(int eachEach : each)
                PrintHelper.echo(eachEach + " ");
            PrintHelper.echoLn("");
        }
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for(int i=0;i<A.length;i++) {
            for(int left=0, right = A[i].length-1;left<right;left++,right--) {
                int backup = A[i][left];
                A[i][left] = A[i][right];
                A[i][right] = backup;
            }
            for(int j=0;j<A[i].length;j++) {
                if(A[i][j] == 0)
                    A[i][j] = 1;
                else
                    A[i][j] = 0;
            }
        }
        return A;
    }
}