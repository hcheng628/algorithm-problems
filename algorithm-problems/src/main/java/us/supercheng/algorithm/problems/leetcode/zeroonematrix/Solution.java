package us.supercheng.algorithm.problems.leetcode.zeroonematrix;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int[][] updateMatrix(int[][] matrix) {
        int rowLen = matrix.length,
                colLen = matrix[rowLen-1].length;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> queue = new LinkedList<>();

        for (int i=0;i<rowLen;i++)
            for (int j=0;j<colLen;j++)
                if (matrix[i][j] == 1)
                    matrix[i][j] = Integer.MAX_VALUE;
                else
                    queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] pos = queue.remove();
            for (int[] dir : dirs) {
                int x = pos[0] + dir[0],
                        y = pos[1] + dir[1];
                if (x < 0 || y < 0 || x >= rowLen || y >= colLen)
                    continue;
                if (matrix[x][y] > matrix[pos[0]][pos[1]] + 1) {
                    matrix[x][y] = matrix[pos[0]][pos[1]] + 1;
                    queue.add(new int[] {x, y});
                }
            }
        }

        return matrix;
    }
}