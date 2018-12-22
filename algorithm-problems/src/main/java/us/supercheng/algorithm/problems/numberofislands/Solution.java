package us.supercheng.algorithm.problems.numberofislands;

class Solution {

    public int numIslands(char[][] grid) {
        int ret = 0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == '0')
                    continue;
                ret++;
                this.markSameIsland(grid, i, j);
            }
        return ret;
    }

    private void markSameIsland(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if(i+1 < grid.length && grid[i+1][j] == '1')
            this.markSameIsland(grid, i+1, j);

        if(i > 0 && grid[i-1][j] == '1')
            this.markSameIsland(grid, i-1, j);

        if(j+1 < grid[i].length && grid[i][j+1] == '1')
            this.markSameIsland(grid, i, j+1);

        if(j > 0 && grid[i][j-1] == '1')
            this.markSameIsland(grid, i, j-1);
    }
}