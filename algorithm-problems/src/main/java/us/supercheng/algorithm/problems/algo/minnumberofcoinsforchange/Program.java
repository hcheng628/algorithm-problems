package us.supercheng.algorithm.problems.algo.minnumberofcoinsforchange;

import java.util.*;

public class Program {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        if (n == 0)
            return 0;

        int[] dp = new int[n+1];

        for (int d : denoms) {
            if (d == n)
                return 1;
            else if (d > n)
                break;

            dp[d] = 1;
            for (int i=d+1; i<=n; i++) {
                int prev = dp[i-d];
                if (prev == 0)
                    continue;

                if (dp[i] == 0)
                    dp[i] = prev + (prev != 0 ? 1 : 0);
                else
                    dp[i] = Math.min(prev + (prev != 0 ? 1 : 0), dp[i]);
            }
        }

        return dp[n] == 0 ? -1 : dp[n];
    }
}


