package us.supercheng.algorithm.problems.leetcode.shift2dgrid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        int m = grid.length,
            n = grid[m-1].length;

        for (;k>0;k--) {
            int[][] copy = new int[m][n];
            for (int i=0;i<m;i++)
                for (int j=0;j<n-1;j++)
                    copy[i][j+1] = grid[i][j];
            for (int i=0;i<m-1;i++)
                copy[i+1][0] = grid[i][n-1];
            copy[0][0] = grid[m-1][n-1];
            grid = copy;
        }

        for (int[] row : grid)
            ret.add(Arrays.stream(row).boxed().collect(Collectors.toList()));
        return ret;
    }

    public List<List<Integer>> shiftGridFast(int[][] grid, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        int m = grid.length,
                n = grid[0].length,
                size = m * n,
                idx = size - k % size;

        for (int i=0;i<m;i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j=0;j<n;j++,idx++) {
                if (idx == size)
                    idx = 0;
                row.add(grid[idx/n][idx%n]);
            }
            ret.add(row);
        }
        return ret;
    }
}