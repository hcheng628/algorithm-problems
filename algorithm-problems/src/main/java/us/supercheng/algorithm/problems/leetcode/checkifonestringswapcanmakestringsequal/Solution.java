package us.supercheng.algorithm.problems.leetcode.checkifonestringswapcanmakestringsequal;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        List<Character> l1 = new ArrayList<>();
        List<Character> l2 = new ArrayList<>();

        for (int i=0, len=s1.length(); i<len; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 != c2) {
                l1.add(c1);
                l2.add(c2);
                if (l1.size() > 2)
                    return false;
            }
        }

        return l1.isEmpty() || (l1.size() == 2 && l1.get(0) == l2.get(1) && l1.get(1) == l2.get(0));
    }

}