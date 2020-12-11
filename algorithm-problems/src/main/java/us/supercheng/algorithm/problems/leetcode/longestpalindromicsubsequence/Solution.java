package us.supercheng.algorithm.problems.leetcode.longestpalindromicsubsequence;

class Solution {
    private Integer[][] memo;

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        this.memo = new Integer[len][len];
        return this.helper(s.toCharArray(), 0, len-1, 0);
    }

    private int helper(char[] chars, int from, int to, int curr) {
        if (this.memo[from][to] != null)
            return this.memo[from][to];
        else if (from == to)
            return 1;
        else if (to < from)
            return 0;

        if (chars[from] == chars[to])
            this.memo[from][to] = this.helper(chars, from+1, to-1, curr) + 2;
        else
            this.memo[from][to] = Math.max(this.helper(chars, from+1, to, curr),this.helper(chars, from, to-1, curr));

        return this.memo[from][to];
    }
}