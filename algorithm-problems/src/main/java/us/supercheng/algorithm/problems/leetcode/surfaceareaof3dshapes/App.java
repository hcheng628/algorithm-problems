package us.supercheng.algorithm.problems.leetcode.surfaceareaof3dshapes;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int[][] grid = {{2,2,2},{2,1,2},{2,2,2}};
        PrintHelper.echoLn("Total Surface Count: " + new App().surfaceArea(grid));
    }

    public int surfaceArea(int[][] grid) {
        int ret = 0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[i].length;j++)
                if(grid[i][j] > 0)
                    ret += this.helper(grid, i, j, grid[i][j]) + 2;
        return ret;
    }

    private int helper(int[][] grid, int x, int y, int z) {
        int ret = 0;
        for(int i=1;i<=z;i++) {
            if((x-1 >= 0 && grid[x-1][y]<i) || (x-1 < 0))
                ret++;
            if((x+1 <= grid.length-1 && grid[x+1][y] < i) || (x+1 > grid.length-1))
                ret++;
            if((y-1 >= 0 && grid[x][y-1] < i) || (y-1 < 0))
                ret++;
            if((y+1 <= grid[x].length-1 && grid[x][y+1] < i) || (y+1 > grid[x].length-1))
                ret++;
        }
        return ret;
    }
}