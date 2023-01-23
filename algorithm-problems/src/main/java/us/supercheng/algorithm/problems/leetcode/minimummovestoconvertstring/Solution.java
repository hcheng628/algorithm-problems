package us.supercheng.algorithm.problems.leetcode.minimummovestoconvertstring;

public class Solution {

    public int minimumMoves(String s) {
        if (s == null || s.length() < 1)
            return 0;

        int ret = 0;

        for (int i = 0, len = s.length(); i < len; i++)
            if (s.charAt(i) == 'X') {
                i += 2;
                ret++;
            }

        return ret;
    }

}
