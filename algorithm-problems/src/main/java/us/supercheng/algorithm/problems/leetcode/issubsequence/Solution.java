package us.supercheng.algorithm.problems.leetcode.issubsequence;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int idxS = 0, idxT = 0;

        while (idxS < s.length() && idxT < t.length()) {
            if (s.charAt(idxS) == t.charAt(idxT)) {
                idxS++;
                idxT++;
            } else
                idxT++;
        }
        return idxS == s.length();
    }
}