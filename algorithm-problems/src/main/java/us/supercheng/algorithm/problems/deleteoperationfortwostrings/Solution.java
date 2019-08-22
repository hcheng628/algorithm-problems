package us.supercheng.algorithm.problems.deleteoperationfortwostrings;

class Solution {

    public int minDistance(String word1, String word2) {
        int len1 = word1.length(),
                len2 = word2.length();

        if (len1 == 0 || len2 == 0)
            return Math.abs(len1 - len2);

        int dp[][] = new int [len1+1][len2+1];
        char[] chars1 = word1.toCharArray(),
                chars2 = word2.toCharArray();

        for (int i=1;i<=len1;i++)
            for (int j=1;j<=len2;j++)
                dp[i][j] = chars1[i-1] == chars2[j-1] ? 1 + dp[i-1][j-1] : Math.max(dp[i-1][j], dp[i][j-1]);

        return (len1 + len2) - dp[len1][len2] * 2;
    }

}