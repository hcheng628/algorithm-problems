package us.supercheng.algorithm.problems.islandperimeter;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int[][] island = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        PrintHelper.echoLn(new App().islandPerimeter(island));
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
}