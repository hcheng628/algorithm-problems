package us.supercheng.algorithm.problems.leetcode.interleavingstring;

public class Solution {

    private Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;

        this.memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return this.helper(s1, s2, s3, 0, 0, 0);
    }

    private boolean helper(String a, String b, String c, int idxA, int idxB, int idxC) {
        if (a.length() == idxA && b.length() == idxB && c.length() == idxC)
            return true;

        if (this.memo[idxA][idxB] != null)
            return this.memo[idxA][idxB];

        return this.memo[idxA][idxB] = (idxA < a.length() && c.charAt(idxC) == a.charAt(idxA) && this.helper(a, b, c, idxA + 1, idxB, idxC + 1)) ||
                (idxB < b.length() && c.charAt(idxC) == b.charAt(idxB) && this.helper(a, b, c, idxA, idxB + 1, idxC + 1));
    }

}
