package us.supercheng.algorithm.problems.nthtribonaccinumber;

class Solution {

    public int tribonacciDP(int n) {
        if (n == 0)
            return 0;
        else if (n == 1 || n == 2)
            return 1;

        int [] dp = new int [n+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i=3;i<=n;i++)
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];

        return dp[n];
    }

    public int tribonacciRec(int n) {
        return n == 0 ? 0 : ((n == 1 || n == 2) ? 1 : tribonacciRec(n-1) + tribonacciRec(n-2) + tribonacciRec(n-3));
    }

    Integer[] memo;

    public int tribonacciMemo(int n) {
        this.memo = new Integer[n+1];
        return this.doMemo(n);
    }

    public int doMemo(int n) {
        if (n == 0)
            return 0;
        else if (n == 1 || n == 2)
            return 1;
        else if (this.memo[n] != null)
            return this.memo[n];

        this.memo[n] = doMemo(n-1) + doMemo(n-2) + doMemo(n-3);
        return this.memo[n];
    }

    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1 || n == 2)
            return 1;
        int t0 = 0,
                t1 = 1,
                t2 = 1;
        for (int i=3;i<=n;i++) {
            int curr = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = curr;
        }
        return t2;
    }
}