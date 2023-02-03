package us.supercheng.algorithm.problems.leetcode.findfirstpalindromicstringinthearray;

import java.util.Arrays;
import java.util.Optional;

public class Solution {

    public String firstPalindrome(String[] words) {
        return Arrays.stream(words).filter(this::isP).findFirst().orElse("");
    }

    private boolean isP(String s) {
        if (s == null || s.length() < 2)
            return true;

        for (int left = 0, right = s.length() - 1; left < right; left++, right--)
            if (s.charAt(left) != s.charAt(right))
                return false;

        return true;
    }

}
