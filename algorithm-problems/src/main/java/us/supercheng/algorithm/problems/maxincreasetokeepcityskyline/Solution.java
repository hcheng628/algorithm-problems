package us.supercheng.algorithm.problems.maxincreasetokeepcityskyline;

public class Solution {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int len = grid.length,
                width = grid[0].length,
                ret = 0;

        int[] maxTop = new int[width],
                maxLeft = new int[len];

        for (int row=0;row<len;row++) {
            int rowMax = 0;
            for (int col=0;col<grid[row].length;col++)
                if(grid[row][col] > rowMax)
                    rowMax = grid[row][col];
            maxLeft[row] = rowMax;
        }

        for (int col=0;col<width;col++) {
            int maxCol = 0;
            for (int[] ints : grid)
                if (ints[col] > maxCol)
                    maxCol = ints[col];
            maxTop[col] = maxCol;
        }

        for (int row=0;row<len;row++)
            for (int col=0;col<width;col++)
                ret += Math.abs(grid[row][col] - Math.min(maxTop[col], maxLeft[row]));

        return ret;
    }
}