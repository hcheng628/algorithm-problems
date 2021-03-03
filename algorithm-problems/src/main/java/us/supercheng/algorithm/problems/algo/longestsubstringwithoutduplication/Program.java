package us.supercheng.algorithm.problems.algo.longestsubstringwithoutduplication;

import java.util.HashSet;
import java.util.Set;

public class Program {

    // Time: O(n) Space: O(n)
    public static String longestSubstringWithoutDuplication(String str) {
        int sLeft = 0;
        int sRight = 0;
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();

        for (int left = 0, right = 0, len = chars.length; left < len; )
            if (set.contains(chars[right])) {
                set.remove(chars[left]);
                left++;
            } else {
                set.add(chars[right]);

                if (right - left > sRight - sLeft) {
                    sLeft = left;
                    sRight = right;
                }

                if (right + 1 < len)
                    right++;
                else {
                    set.remove(chars[left]);
                    left++;
                }
            }

        return str.substring(sLeft, sRight + 1);
    }

}
