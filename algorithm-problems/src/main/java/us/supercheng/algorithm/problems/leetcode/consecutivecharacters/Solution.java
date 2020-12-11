package us.supercheng.algorithm.problems.leetcode.consecutivecharacters;

public class Solution {

    public int maxPower(String s) {
        if (s == null || s.length() < 1)
            return 0;

        int ret = 1;

        for (int left=0, right=1, len = s.length(); left < right && left < len && right < len; right++)
            if (s.charAt(left) == s.charAt(right))
                ret = Math.max(right - left + 1, ret);
            else
                left = right;

        return ret;
    }

}