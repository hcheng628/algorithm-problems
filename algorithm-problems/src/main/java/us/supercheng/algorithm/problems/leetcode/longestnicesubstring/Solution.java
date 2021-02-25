package us.supercheng.algorithm.problems.leetcode.longestnicesubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String longestNiceSubstring(String s) {
        String ret = "";

        for (int i=0, len=s.length(); i<len && len - i > ret.length(); i++)
            for (int j=i; j<len; j++) {
                String curr = s.substring(i, j + 1);
                if (j + 1 - i > ret.length() && this.isNice(curr))
                    ret = curr;
            }

        return ret;
    }

    private boolean isNice(String s) {
        if (s == null || s.length() < 2)
            return false;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, 1);

        for (int i=0; i<27;i++)
            if (map.get((char) ('a' + i)) != map.get((char) ('A' + i)))
                return false;

        return true;
    }

}