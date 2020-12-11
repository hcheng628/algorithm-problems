package us.supercheng.algorithm.problems.leetcode.onesandzeros;

class Solution {

    private Integer[][][] memo;

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length < 1)
            return 0;
        this.memo = new Integer[strs.length+1][m+1][n+1];
        return this.dfs(strs, 0, m, n);
    }

    private int dfs(String[] strs, int idx, int zeros, int ones) {
        if (idx == strs.length)
            return 0;

        if (this.memo[idx][zeros][ones] != null)
            return this.memo[idx][zeros][ones];

        char[] curr = strs[idx].toCharArray();
        int currZeros = this.count(curr, '0'),
                currOnes = this.count(curr, '1'),
                ret = 0;

        if (currZeros <= zeros && currOnes <= ones)
            ret = this.dfs(strs, idx+1, zeros - currZeros, ones - currOnes) + 1;
        ret = Math.max(ret, this.dfs(strs, idx+1, zeros, ones));

        this.memo[idx][zeros][ones] = ret;
        return this.memo[idx][zeros][ones];
    }

    private int count(char[] chars, char target) {
        int ret = 0;
        for (char c : chars)
            if (c == target)
                ret++;
        return ret;
    }
}