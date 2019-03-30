package us.supercheng.algorithm.problems.perfectsquares;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numSquaresDP(int n) {
        int [] dp = new int [n+1];
        for (int i=1;i<=n;i++) {
            int res = Integer.MAX_VALUE;
            for (int j=1;i-j*j>=0;j++)
                res = Math.min(res, dp[i-j*j]+1);
            dp[i] = res;
        }
        return dp[n];
    }

    public int numSquares(int n) {
        Queue<int []> queue = new LinkedList<>();
        boolean [] visited = new boolean [n];
        int [] initPoint = {n, 0};
        queue.add(initPoint);
        while (!queue.isEmpty()) {
            int [] eachFromTo = queue.poll();
            for (int i=1;;i++) {
                int res = eachFromTo[0]- i*i;
                if (res == 0)
                    return eachFromTo[1] + 1;
                else if (res < 0)
                    break;
                if (!visited[res]) {
                    int [] eachBFSPoint = {res, eachFromTo[1] + 1};
                    queue.add(eachBFSPoint);
                    visited[res] = true;
                }
            }
        }

        throw new IllegalArgumentException("Invalid Input");
    }

    Integer [] dp;

    public int numSquaresRec(int n) {
        this.dp = new Integer[n+1];
        this.dp[1] = 1;
        return this.dfs(n);
    }

    private int dfs(int n) {
        if(this.dp[n] != null)
            return this.dp[n];

        int min = Integer.MAX_VALUE;

        for (int i=1;i*i<=n;i++) {
            if (i*i == n)
                return 1;
            min = Math.min(this.dfs(n - i*i), min);
        }

        this.dp[n] = min+1;

        return this.dp[n];
    }
}