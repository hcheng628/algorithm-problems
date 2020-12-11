package us.supercheng.algorithm.problems.leetcode.compareversionnumbers;

class Solution {
    public int compareVersion(String version1, String version2) {
        String [] v1 = version1.split("\\."),
                v2 = version2.split("\\.");

        int len = v1.length > v2.length ? v2.length : v1.length;
        for(int i=0;i<len;i++) {
            int tempV1 = Integer.parseInt(v1[i]),
                    tempV2 = Integer.parseInt(v2[i]);
            if(tempV1 != tempV2)
                return tempV1 < tempV2 ? -1 : 1;
        }

        if(v1.length == v2.length)
            return 0;
        return v1.length > v2.length ? this.checkZero(v1, len) ? 0 : 1 : this.checkZero(v2, len) ? 0 : -1;
    }

    private boolean checkZero(String [] v, int start) {
        for(int i=start;i<v.length;i++)
            if(Integer.parseInt(v[i]) != 0)
                return false;
        return true;
    }
}