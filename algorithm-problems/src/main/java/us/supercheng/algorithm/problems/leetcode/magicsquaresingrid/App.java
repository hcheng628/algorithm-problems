package us.supercheng.algorithm.problems.leetcode.magicsquaresingrid;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String [] args) {
        int [][] grid = {{3,10,2,3,4},{4,5,6,8,1},{8,8,1,6,8},{1,3,5,7,1},{9,4,9,2,9}};
        PrintHelper.echoLn(new App().numMagicSquaresInside(grid));
    }

    public int numMagicSquaresInside(int[][] grid) {
        int ret = 0;
        for(int i=0;i<grid.length-2;i++)
            for(int j=0;j<grid[i].length-2;j++) {
                if((grid[i][j] < 1 || grid[i][j] > 9) ||
                        (grid[i][j+1] < 1 || grid[i][j+1] > 9) ||
                        (grid[i][j+2] < 1 || grid[i][j+2] > 9) ||
                        (grid[i+1][j] < 1 || grid[i+1][j] > 9) ||
                        (grid[i+1][j+1] < 1 || grid[i+1][j+1] > 9) ||
                        (grid[i+1][j+2] < 1 || grid[i+1][j+2] > 9) ||
                        (grid[i+2][j] < 1 || grid[i+2][j] > 9) ||
                        (grid[i+2][j+1] < 1 || grid[i+2][j+1] > 9) ||
                        (grid[i+2][j+2] < 1 || grid[i+2][j+2] > 9))
                    continue;
                int row1 = grid[i][j] + grid[i][j+1] + grid[i][j+2];
                if(grid[i][j] + grid[i+2][j+2] == grid[i][j+2] + grid[i+2][j]
                        && row1 == grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2]
                        && row1 == grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2]
                        && row1 == grid[i][j] + grid[i+1][j] + grid[i+2][j]
                        && row1 == grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1]
                        && row1 == grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2])
                    ret++;
            }
        return ret;
    }
}