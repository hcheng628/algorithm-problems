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


    /* Different Implementation */

    private final int[][] DIR = {{1,0},{-1,0},{0,1},{0,-1}};
    private boolean[][] visited;

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        this.visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i=0;i<grid.length;i++)
            for (int j=0;j<grid[i].length;j++)
                if (grid[i][j] == '1' && !this.visited[i][j]) {
                    this.bfs(grid, i, j);
                    count++;
                }

        return count;

    }

    private void bfs(char[][] grid, int x, int y) {
        this.visited[x][y] = true;

        for (int i=0;i<4;i++) {
            int newX = DIR[i][0] + x,
                    newY = DIR[i][1] + y;
            if (this.isInArea(grid, newX, newY) && !this.visited[newX][newY] && grid[newX][newY] == '1')
                this.bfs(grid, newX, newY);
        }
    }

    private boolean isInArea(char[][] grid, int x, int y) {
        return x > -1 && y > -1 && x < grid.length && y < grid[x].length;
    }
}