package us.supercheng.algorithm.problems.algo.numberofwaystomakechange;

import java.util.*;

public class Program {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int d : denoms)
            for (int i=d; i<=n; i++)
                dp[i] += dp [i-d];

        return dp[n];
    }
}
