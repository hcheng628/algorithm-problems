package us.supercheng.algorithm.problems.leetcode.islandperimeter;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int[][] island = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        PrintHelper.echoLn(new App().islandPerimeter(island));
        PrintHelper.echoLn(new App().islandPerimeter2(island));
    }

    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == 1) {
                    if(i==0) {
                        count++;
                        if(grid.length == 1)
                            count++;
                        if(grid.length != 1 && grid[i + 1][j] != 1)
                            count++;
                    } else if(i==grid.length-1) {
                        if(grid[i-1][j] != 1)
                            count++;
                        count++;
                    } else {
                        if(grid[i-1][j] != 1)
                            count++;
                        if(grid[i+1][j] != 1)
                            count++;
                    }
                    if(j==0) {
                        if(grid[i].length == 1)
                            count++;
                        if(grid[i].length != 1 && grid[i][j+1] != 1)
                            count++;
                        count++;
                    } else if (j == grid[i].length-1) {
                        if(grid[i][j-1] != 1)
                            count++;
                        count++;
                    } else {
                        if(grid[i][j+1] != 1)
                            count++;
                        if(grid[i][j-1] != 1)
                            count++;
                    }
                }
            }
        }
        return count;
    }

    public int islandPerimeter2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int ret = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    ret += 4;
                    if(i-1>=0 && grid[i-1][j] == 1)
                        ret -=2;
                    if(j-1>=0 && grid[i][j-1] == 1)
                        ret -=2;
                }
            }
        }
        return ret;
    }
}