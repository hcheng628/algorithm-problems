package us.supercheng.algorithm.problems.leetcode.minimumpathsum;

public class App {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length < 1 || grid[0].length < 1)
            return 0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[i].length;j++) {
                if(i == 0 && j != 0)
                    grid[i][j] += grid[i][j-1];
                else if (i != 0 && j == 0)
                    grid[i][j] += grid[i-1][j];
                else if(i != 0 && j != 0)
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        return grid[grid.length-1][grid[grid.length-1].length-1];
    }
}