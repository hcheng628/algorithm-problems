package us.supercheng.algorithm.problems.countnegativenumbersinasortedmatrix;

public class Solution {
    public int countNegatives(int[][] grid) {
        int ret = 0;

        for (int i=0, len=grid.length, width=grid[0].length; i<len; i++) {
            int count = 0;

            for (int idx = width -1; idx >-1 && grid[i][idx] < 0; idx--)
                count++;

            ret += count;
        }

        return ret;
    }
}
