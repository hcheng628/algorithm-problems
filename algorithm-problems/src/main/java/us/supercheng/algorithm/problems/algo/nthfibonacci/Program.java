package us.supercheng.algorithm.problems.algo.nthfibonacci;

public class Program {

    public static int getNthFib_Solution1(int n) {
        if (n < 1)
            return -1;
        else if (n == 1)
            return 0;
        else if (n == 2)
            return 1;
        return getNthFib_Solution1(n-1) + getNthFib_Solution1(n-2);
    }

    public static int getNthFib_Solution2(int n) {
        if (n < 1)
            return -1;
        if (n == 1)
            return 0;
        else if (n == 2)
            return 1;

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i=2; i<n; i++)
            dp[i] = dp[i-1] + dp[i-2];

        return dp[n-1];
    }

    public static int getNthFib_Solution3(int n) {
        if (n < 1)
            return -1;
        else if (n == 1)
            return 0;
        else if (n == 2)
            return 1;

        int ret = 0;

        for (int prev=0, prevPrev=1, i=2; i<=n; i++) {
            ret = prev + prevPrev;
            prevPrev = prev;
            prev = ret;
        }

        return ret;
    }
}
