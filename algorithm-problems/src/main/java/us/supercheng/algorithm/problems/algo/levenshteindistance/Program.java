package us.supercheng.algorithm.problems.algo.levenshteindistance;

import java.util.*;

public class Program {

    public static int levenshteinDistance(String str1, String str2) {
        int len1 = str1.length(),
            len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        // base
        for (int i=1; i<=len1; i++)
            dp[i][0] = dp[i-1][0] + 1;

        for (int i=1; i<=len2; i++)
            dp[0][i] = dp[0][i-1] + 1;

        // n -> n+1
        for (int i=1; i<=len1;i++)
            for (int j=1; j<=len2; j++)
                if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;

        return dp[len1][len2];
    }
}
