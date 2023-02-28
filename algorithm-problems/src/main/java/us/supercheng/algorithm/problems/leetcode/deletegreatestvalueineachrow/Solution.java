package us.supercheng.algorithm.problems.leetcode.deletegreatestvalueineachrow;

import java.util.Arrays;

class Solution {

    public int deleteGreatestValue(int[][] grid) {
        int ret = 0;
        Arrays.stream(grid).forEach(Arrays::sort);

        for (int max = 0, c = grid[0].length - 1, rLen = grid.length; c > -1; c--, ret += max) {
            max = grid[0][c];
            for (int r = 1; r < rLen; r++)
                max = Math.max(grid[r][c], max);
        }

        return ret;
    }

}
