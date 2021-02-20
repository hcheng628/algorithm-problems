package us.supercheng.algorithm.problems.algo.numbersinpi;

import java.util.*;

public class Program {

    public static int numbersInPi(String pi, String[] numbers) {
        int len = pi.length();
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(numbers));
        return helper(pi, 0, len, set, new Integer[len]);
    }

    private static int helper(String s, int idx, int len, Set<String> set, Integer[] memo) {
        if (memo[idx] != null)
            return memo[idx];

        for (int i=idx+1; i<=len; i++)
            if (set.contains(s.substring(idx, i)))
                if (s.substring(i).length() == 0)
                    return memo[idx] = 0;
                else {
                    int ans = helper(s, i, len, set, memo);
                    if (ans != -1 && (memo[idx] == null || ans + 1 < memo[idx]))
                        memo[idx] = ans + 1;
                }

        if (memo[idx] == null)
            memo[idx] = -1;

        return memo[idx];
    }
}


