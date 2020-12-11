package us.supercheng.algorithm.problems.leetcode.spiralmatrixii;

public class App {
    public int[][] generateMatrix(int n) {
        int [][] ret = new int [n][n];
        boolean [][] visited = new boolean[n][n];
        for(int size = n*n, count = size, x=0, y=0;count>0;) {
            for(;y<n && !visited[x][y];y++,count--)
                this.helper(visited, ret, x, y, size - count + 1);
            y--;
            x++;

            for(;x<n && !visited[x][y];x++,count--)
                this.helper(visited, ret, x, y, size - count + 1);
            x--;
            y--;

            for(;y>-1 && !visited[x][y];y--,count--)
                this.helper(visited, ret, x, y, size - count + 1);
            x--;
            y++;

            for(;x>-1 && !visited[x][y];x--,count--)
                this.helper(visited, ret, x, y, size - count + 1);
            x++;
            y++;
        }
        return ret;
    }

    private void helper(boolean [][] visited, int [][] mat, int x, int y, int val) {
        visited[x][y] = true;
        mat[x][y] = val;
    }
}