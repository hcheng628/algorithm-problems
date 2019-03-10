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
}