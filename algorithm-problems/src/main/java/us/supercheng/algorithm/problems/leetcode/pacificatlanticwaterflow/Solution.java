package us.supercheng.algorithm.problems.leetcode.pacificatlanticwaterflow;

import java.util.ArrayList;
import java.util.List;

class Solution {

    final int [][] DIRs = {{1,0},{-1,0},{0,1},{0,-1}};
    Boolean [][] visited;

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ret = new ArrayList<>();

        if (matrix == null || matrix.length == 0)
            return ret;

        this.visited = new Boolean[matrix.length][matrix[0].length];

        for (int i=0;i<matrix.length;i++)
            for (int j=0;j<matrix[i].length;j++)
                if (this.travel(matrix, i, j, matrix[i][j], true) && this.travel(matrix, i, j, matrix[i][j], false)) {
                    ret.add(new int[]{i, j});
                    this.visited[i][j] = true;
                }

        return ret;
    }

    private boolean travel(int[][] mat, int x, int y, int fromVal, boolean isPac) {
        if ((isPac && (x <= 0 || y <= 0)) || (!isPac && (x >= mat.length-1 || y >= mat[x].length-1)))
            return true;

        boolean ret = false;
        this.visited[x][y] = false;

        for (int i=0;i<DIRs.length && !ret;i++) {
            int xx = DIRs[i][0] + x, yy = DIRs[i][1] + y;
            if (((xx > -1 && yy > -1 && xx < mat.length && yy < mat[x].length) && mat[xx][yy] <= fromVal) &&
                    ((this.visited[xx][yy] != null && this.visited[xx][yy]) ||
                            (this.visited[xx][yy] == null && this.travel(mat, xx, yy, mat[xx][yy], isPac))))
                ret = true;
        }

        this.visited[x][y] = null;
        return ret;
    }
}