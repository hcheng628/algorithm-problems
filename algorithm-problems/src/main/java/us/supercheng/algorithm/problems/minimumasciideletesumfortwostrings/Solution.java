package us.supercheng.algorithm.problems.minimumasciideletesumfortwostrings;

class Solution {

    private Integer[][] memo;

    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length(),
            len2 = s2.length();
        this.memo = new Integer[len1][len2];
        return this.helper(s1.toCharArray(), s2.toCharArray(), len1-1, len2-1);
    }

    private int helper(char[] chars1, char[] chars2, int idx1, int idx2) {
        if (idx1 < 0 && idx2 < 0)
            return 0;
        if (idx1 < 0)
            return this.helper(chars1, chars2, idx1, idx2-1) + chars2[idx2];
        if (idx2 < 0)
            return this.helper(chars1, chars2, idx1-1, idx2) + chars1[idx1];

        if (this.memo[idx1][idx2] != null)
            return this.memo[idx1][idx2];
        if (chars1[idx1] == chars2[idx2])
            return this.memo[idx1][idx2] = this.helper(chars1, chars2, idx1-1, idx2-1);
        return this.memo[idx1][idx2] = Math.min(this.helper(chars1, chars2, idx1-1, idx2) + chars1[idx1],
                this.helper(chars1, chars2, idx1, idx2-1) + chars2[idx2]);
    }
}