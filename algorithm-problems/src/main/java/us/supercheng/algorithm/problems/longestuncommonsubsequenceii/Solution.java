package us.supercheng.algorithm.problems.longestuncommonsubsequenceii;

class Solution {

    public int findLUSlength(String[] strs) {
        int ret = -1, j = 0, n = strs.length;
        for (int i=0;i<n;i++) {
            for (j=0;j<n;j++) {
                if (i==j)
                    continue;
                if (this.findIt(strs[i], strs[j]))
                    break;
            }
            if (j == n && strs[i].length() > ret)
                ret = strs[i].length();
        }
        return ret;
    }


    private boolean findIt(String subS, String s) {
        int idxSubS = 0;
        for (int idxS = 0;idxS < s.length() && idxSubS < subS.length();idxS++)
            if (s.charAt(idxS) == subS.charAt(idxSubS))
                idxSubS++;
        return idxSubS == subS.length();
    }
}