package us.supercheng.algorithm.problems.outofboundarypaths;

public class Solution {

    public int findPathsBottomUp(int m, int n, int N, int i, int j) {
        int[][][] memo = new int[N+1][m][n];
        final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int step=1;step<=N;step++)
            for (int row=0;row<m;row++)
                for (int col=0;col<n;col++)
                    for(int[] dir : DIRS) {
                        int newRow = dir[0] + row,
                                newCol = dir[1] + col;
                        memo[step][row][col] = newRow < 0 || newCol < 0 || newRow >= m || newCol >= n ? memo[step][row][col] + 1 :
                                (memo[step][row][col] + memo[step-1][newRow][newCol]) % 1000000007;
                    }
        return memo[N][i][j] ;
    }


    final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Integer[][][] memo;
    int M;
    int N;

    public int findPathsTopDown(int m, int n, int N, int i, int j) {
        this.memo = new Integer[N+1][m][n];
        this.M = m;
        this.N = n;
        return this.travel(N, i, j);
    }

    private int travel(int steps, int x, int y) {
        if (steps <= 0)
            return 0;

        if (this.memo[steps][x][y] != null)
            return this.memo[steps][x][y];
        else
            this.memo[steps][x][y] = 0;

        for (int[] dir : DIRS) {
            int newX = x + dir[0], newY = y + dir[1];
            if (newX < 0 || newY < 0 || newX >= this.M || newY >= this.N)
                this.memo[steps][x][y]++;
            else
                this.memo[steps][x][y] = (this.memo[steps][x][y] + this.travel(steps-1, newX, newY)) % 1000000007;
        }
        return memo[steps][x][y];
    }
}

//out-of-boundary-paths