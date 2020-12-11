package us.supercheng.algorithm.problems.leetcode.knightprobabilityinchessboard;

class Solution {

    Double[][][] memo;
    int[][] DIRS = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};

    public double knightProbability(int N, int K, int r, int c) {
        this.memo = new Double[N][N][K+1];
        return this.travel(N, K, r, c) / Math.pow(8,K);
    }

    private double travel(int N, int step, int r, int c) {
        if (step == 0)
            return 1.0;

        if (this.memo[r][c][step] != null)
            return this.memo[r][c][step];

        this.memo[r][c][step] = 0.0;
        for (int[] dir : this.DIRS) {
            int newR = dir[0] + r,
                    newC = dir[1] + c;
            if (newR > -1 && newC > -1 && newR < N && newC < N)
                this.memo[r][c][step] += this.travel(N, step-1, newR, newC);
        }

        return this.memo[r][c][step];
    }
}