package us.supercheng.algorithm.problems.rottingoranges;

import java.util.ArrayList;

class Solution {
    public int orangesRotting(int[][] grid) {
        int goodCount = 0, rottenCount = 0, minutes = 0;

        for (int i=0;i<grid.length;i++)
            for (int j=0;j<grid[i].length;j++)
                if (grid[i][j] == 1)
                    goodCount++;
                else if (grid[i][j] == 2)
                    rottenCount++;

        for (;true;minutes++) {
            int eachRottenCount = 0;
            ArrayList<Integer> xList = new ArrayList<>(),
                    yList = new ArrayList<>();
            for (int i=0;i<grid.length;i++)
                for (int j=0;j<grid[i].length;j++)
                    if (grid[i][j] == 2) {
                        xList.add(i);
                        yList.add(j);
                    }

            for (int i=0;i<xList.size();i++)
                eachRottenCount += this.makeRotten(grid, xList.get(i), yList.get(i));

            if (eachRottenCount == 0)
                break;
            goodCount -= eachRottenCount;
        }

        return goodCount > 0 ? -1 : minutes;
    }

    private int makeRotten(int[][] grid, int x, int y) {
        int count = 0;
        if (x+1 < grid.length && grid[x+1][y] == 1) {
            grid[x+1][y] = 2;
            count++;
        }

        if (x-1 > -1 && grid[x-1][y] == 1) {
            grid[x-1][y] = 2;
            count++;
        }

        if (y+1 < grid[x].length && grid[x][y+1] == 1) {
            grid[x][y+1] = 2;
            count++;
        }

        if (y-1 > -1 && grid[x][y-1] == 1) {
            grid[x][y-1] = 2;
            count++;
        }
        return count;
    }
}