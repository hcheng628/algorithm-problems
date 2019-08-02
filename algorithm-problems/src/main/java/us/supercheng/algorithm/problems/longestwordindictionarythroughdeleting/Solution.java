package us.supercheng.algorithm.problems.longestwordindictionarythroughdeleting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {

    public String findLongestWord(String s, List<String> d) {

        Collections.sort(d, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.length() != b.length() ? b.length() - a.length() : a.compareTo(b);
            }
        });

        char[] chars = s.toCharArray();
        for (String each : d) {
            int i=0;
            for (char c : chars) {
                if (c == each.charAt(i))
                    i++;
                if (i == each.length())
                    return each;
            }
        }
        return "";
    }
}