package us.supercheng.algorithm.problems.soupservings;

public class Solution {

    Double[][] memo;

    public double soupServings(int N) {
        if (N > 100000)
            return 1.0;

        int res = N / 25;
        if (N % 25 != 0)
            res++;
        this.memo = new Double[res+1][res+1];

        return this.dfs(res, res);
    }

    private double dfs(int a, int b) {
        if (a <= 0) {
            if (b <= 0)
                return .5;
            return 1;
        }

        if (b <= 0)
            return 0;

        if (this.memo[a][b] != null)
            return this.memo[a][b];

        return this.memo[a][b] = .25 * (this.dfs(a-4, b) + this.dfs(a-3, b-1) + this.dfs(a-2, b-2) +  this.dfs(a-1, b-3));
    }
}