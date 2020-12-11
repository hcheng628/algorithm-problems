package us.supercheng.algorithm.problems.leetcode.removealladjacentduplicatesinstring;

class Solution {
    public String removeDuplicates(String S) {
        if (S == null || S.length() == 0)
            return S;

        StringBuilder sb = new StringBuilder(S);

        for (int i=0;i<sb.length()-1;i++)
            if (sb.charAt(i) == sb.charAt(i+1)) {
                sb.replace(i, i+2, "");
                i -=2;
                if (i == -2)
                    i++;
            }

        return sb.toString();
    }
}