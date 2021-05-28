package us.supercheng.algorithm.problems.algo.numberofbinarytreetopologies;

import java.util.*;

public class Program {

    // Time: O(n^2) Space: O(n) Approach: Top Down
    public static int numberOfBinaryTreeTopologies_Solution1(int n) {
        return helper(n, new HashMap<>());
    }

    private static int helper(int n, Map<Integer, Integer> map) {
        if (n < 1) {
            map.put(n, 1);
            return 1;
        }

        if (map.containsKey(n))
            return map.get(n);

        int ret = 0;

        for (int i=0; i<n; i++)
            ret += helper(i, map) * helper(n - i - 1, map);

        map.put(n, ret);
        return ret;
    }

    // Time: O(n^2) Space: O(n) Approach: Bottom Up
    public static int numberOfBinaryTreeTopologies(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i=1; i<=n; i++)
            for (int j=0; j<i; j++)
                dp[i] += dp[i - j - 1] * dp[j];

        return dp[n];
    }
}
