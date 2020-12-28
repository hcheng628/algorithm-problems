package us.supercheng.algorithm.problems.algo.maxsubsetsumnoadjacent;

import java.util.*;

public class Program {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array == null || array.length < 1)
            return 0;
        else if (array.length == 1)
            return array[0];
        else if (array.length == 2)
            return Math.max(array[0], array[1]);

        int len = array.length;
        int[] dp = new int[len];

        dp[0] = array[0];
        dp[1] = Math.max(dp[0], array[1]);

        for (int i=2; i<len; i++) {
            int res = array[i] + dp[i-2];
            dp[i] = res > dp[i-1] ? res : dp[i-1];
        }

        return dp[len-1];
    }
}

