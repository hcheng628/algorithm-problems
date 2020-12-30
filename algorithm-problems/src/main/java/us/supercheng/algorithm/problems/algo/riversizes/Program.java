package us.supercheng.algorithm.problems.algo.riversizes;

import java.util.*;

public class Program {

    public static List<Integer> riverSizes_Solution1(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        List<Integer> ret = new ArrayList<>();
        boolean[][] visited = new boolean[R][C];

        for (int i=0; i<R; i++)
            for (int j=0; j<C; j++)
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    int res = doVisit(visited, matrix, R, C, i, j);
                    if (res > 0)
                        ret.add(res);
                }

        return ret;
    }

    private static int doVisit(boolean[][] visited, int[][] mat, int R, int C, int x, int y) {
        int ret = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            int currX = pos[0];
            int currY = pos[1];

            if (visited[currX][currY])
                continue;
            visited[currX][currY] = true;

            for (int[] next : getNexts(visited, mat, R, C, currX, currY))
                stack.push(next);

            ret++;
        }

        return ret;
    }

    private static List<int[]> getNexts(boolean[][] visited, int[][] mat, int R, int C, int x, int y) {
        List<int[]> ret = new ArrayList<>();

        if (x - 1 > -1 && !visited[x - 1][y] && mat[x - 1][y] == 1)
            ret.add(new int[]{x - 1, y});

        if (x + 1 < R && !visited[x + 1][y] && mat[x + 1][y] == 1)
            ret.add(new int[]{x + 1, y});

        if (y - 1 > -1 && !visited[x][y - 1] && mat[x][y - 1] == 1)
            ret.add(new int[]{x, y - 1});

        if (y + 1 < C && !visited[x][y + 1] && mat[x][y + 1] == 1)
            ret.add(new int[]{x, y + 1});

        return ret;
    }

    public static List<Integer> riverSizes_Solution2(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        List<Integer> ret = new ArrayList<>();

        for (int i=0; i<row; i++)
            for (int j=0; j<col; j++)
                if (matrix[i][j] == 1 && !visited[i][j])
                    ret.add(travel(matrix, row, col, visited, i, j, 0));

        return ret;
    }

    private static int travel(int[][] mat, int row, int col, boolean[][] visited, int x, int y, int curr) {
        if (x < 0 || y < 0 || x >= row || y >= col || visited[x][y] || mat[x][y] == 0)
            return curr;

        visited[x][y] = true;
        int up = travel(mat, row, col, visited, x - 1, y, curr);
        int down = travel(mat, row, col, visited, x + 1, y, curr);
        int left = travel(mat, row, col, visited, x, y - 1, curr);
        int right = travel(mat, row, col, visited, x, y + 1, curr);

        return up + down + left + right + 1;
    }

}