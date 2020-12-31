package us.supercheng.algorithm.problems.algo.removeislands;

import java.util.*;

public class Program {

    public int[][] removeIslands_Solution1(int[][] matrix) {
        if (matrix == null || matrix.length < 3 || matrix[0].length < 3)
            return matrix;

        int R = matrix.length;
        int C = matrix[0].length;

        for (int i=0; i<R; i+=R-1)
            for (int j=0; j<C; j++)
                if (matrix[i][j] == 1)
                    this.fillIsland(matrix, R, C, i, j, 2);

        for (int j=0; j<C; j+=C-1)
            for (int i=0; i<R; i++)
                if (matrix[i][j] == 1)
                    this.fillIsland(matrix, R, C, i, j, 2);

        for (int i=0; i<R; i++)
            for (int j=0; j<C; j++)
                if (matrix[i][j] == 1)
                    matrix[i][j] = 0;
                else if (matrix[i][j] == 2)
                    matrix[i][j] = 1;

        return matrix;
    }

    private void fillIsland(int[][] mat, int R, int C, int x, int y, int val) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            int currX = pos[0];
            int currY = pos[1];

            if (mat[currX][currY] == val)
                continue;
            mat[currX][currY] = val;

            for (int[] next : this.getNexts(mat, R, C, currX, currY))
                stack.push(next);
        }
    }

    private List<int[]> getNexts(int[][] mat, int R, int C, int x, int y) {
        List<int[]> ret = new ArrayList<>();

        if (x - 1 > -1 && mat[x - 1][y] == 1)
            ret.add(new int[]{x - 1, y});
        if (x + 1 < R && mat[x + 1][y] == 1)
            ret.add(new int[]{x + 1, y});
        if (y - 1 > -1 && mat[x][y - 1] == 1)
            ret.add(new int[]{x, y - 1});
        if (y + 1 < C && mat[x][y + 1] == 1)
            ret.add(new int[]{x, y + 1});

        return ret;
    }

    public int[][] removeIslands_Solution2(int[][] matrix) {
        if (matrix == null || matrix.length < 3 || matrix[0].length < 3)
            return matrix;

        int R = matrix.length;
        int C = matrix[0].length;
        boolean[][] visited = new boolean[R][C];

        // handle border 1s
        for (int i=0; i<R; i+=R-1)
            for (int j=0; j<C; j++)
                if (matrix[i][j] == 1 && !visited[i][j])
                    this.markVisited(visited, matrix, R, C, i, j, false);

        for (int j=0; j<C; j+=C-1)
            for (int i=0; i<R; i++)
                if (matrix[i][j] == 1 && !visited[i][j])
                    this.markVisited(visited, matrix, R, C, i, j, false);

        // del islands 1s
        for (int i=1; i<R-1; i++)
            for (int j=1; j<C-1; j++)
                if (matrix[i][j] == 1 && !visited[i][j])
                    this.markVisited(visited, matrix, R, C, i, j, true);

        return matrix;
    }

    private void markVisited(boolean[][] visited, int[][] mat, int R, int C, int x, int y, boolean isDel) {
        if (x < 0 || y < 0 || x >= R || y >= C || visited[x][y] || mat[x][y] == 0)
            return;

        visited[x][y] = true;
        if (isDel)
            mat[x][y] = 0;

        this.markVisited(visited, mat, R, C, x - 1, y, isDel); 	// up
        this.markVisited(visited, mat, R, C, x + 1, y, isDel);  // down
        this.markVisited(visited, mat, R, C, x, y - 1, isDel);  // left
        this.markVisited(visited, mat, R, C, x, y + 1, isDel);  // right
    }
}


