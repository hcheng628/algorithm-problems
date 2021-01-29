package us.supercheng.algorithm.problems.leetcode.findthehighestaltitude;

public class Solution {

    public int largestAltitude(int[] gain) {
        int ret = 0;

        for (int i=0, curr = 0, len=gain.length; i<len; i++) {
            curr += gain[i];
            if (curr > ret)
                ret = curr;
        }

        return ret;
    }

}
