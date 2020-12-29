package us.supercheng.algorithm.problems.leetcode.countofmatchesintournament;

public class Solution {

    // Top-down
    public int numberOfMatchesTD(int n) {
        if (n < 2)
            return 0;

        int matches = n / 2,
            nextRound = n % 2 == 0 ? matches : matches + 1;

        return matches + this.numberOfMatches(nextRound);
    }

    // Bottom-up
    public int numberOfMatches(int n) {
        if (n < 2)
            return 0;

        int[] dp = new int[n+1];

        // init
        dp[2] = 1;

        // transition
        for (int i=3; i<=n; i++) {
            int matches = i / 2,
                nextRound = i % 2 == 0 ? matches : matches + 1;

            dp[i] = matches + dp[nextRound];
        }

        // k = n
        return dp[n];
    }

}