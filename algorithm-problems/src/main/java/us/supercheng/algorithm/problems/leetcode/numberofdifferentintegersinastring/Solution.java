package us.supercheng.algorithm.problems.leetcode.numberofdifferentintegersinastring;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();

        for (int i=0, len=word.length(); i<len; i++)
            if (Character.isDigit(word.charAt(i))) {
                int start = i;
                while (i<len && Character.isDigit(word.charAt(i)))
                    i++;

                String s = word.substring(start, i);
                int lenS = s.length();
                if (s.charAt(0) == '0' && lenS > 1) {
                    int j = 0;
                    while (j<lenS && s.charAt(j) == '0')
                        j++;
                    s = s.substring(j, lenS);
                    if (s.length() == 0)
                        s = "0";
                }

                set.add(s);
            }

        return set.size();
    }
}