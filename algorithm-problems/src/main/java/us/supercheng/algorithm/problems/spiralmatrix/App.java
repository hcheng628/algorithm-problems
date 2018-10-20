package us.supercheng.algorithm.problems.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

public class App {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return ret;
        int x = 0, y = 0, total = matrix[0].length * matrix.length;
        boolean [][] visited = new boolean [matrix.length][matrix[0].length];

        while(total != ret.size()) {
            while(canGoRight(matrix, x, y, visited)) {
                visited[x][y] = true;
                ret.add(matrix[x][y++]);
            }
            x++;
            y--;

            while(canGoDown(matrix, x, y, visited)) {
                visited[x][y] = true;
                ret.add(matrix[x++][y]);
            }
            x--;
            y--;


            while(canGoLeft(x, y, visited)) {
                visited[x][y] = true;
                ret.add(matrix[x][y--]);
            }
            x--;
            y++;

            while(canGoUp(x, y, visited)) {
                visited[x][y] = true;
                ret.add(matrix[x--][y]);
            }
            x++;
            y++;
        }
        return ret;
    }

    private boolean canGoLeft(int x, int y, boolean [][] visited) {
        if(y > -1 && !visited[x][y])
            return true;
        return false;
    }

    private boolean canGoRight(int[][] mat, int x, int y, boolean [][] visited) {
        if(y < mat[0].length && !visited[x][y])
            return true;
        return false;
    }

    private boolean canGoUp(int x, int y, boolean [][] visited) {
        if(x > -1 && !visited[x][y])
            return true;
        return false;
    }

    private boolean canGoDown(int[][] mat, int x, int y, boolean [][] visited) {
        if(x<mat.length && !visited[x][y])
            return true;
        return false;
    }
}
