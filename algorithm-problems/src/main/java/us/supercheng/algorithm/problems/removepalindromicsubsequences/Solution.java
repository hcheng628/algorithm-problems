package us.supercheng.algorithm.problems.removepalindromicsubsequences;

public class Solution {
    public int removePalindromeSub(String s) {
        if (s == null || s.length() < 1)
            return 0;

        boolean isP = true;

        for (int len = s.length(), left = 0, right = len - 1; isP && left < right; )
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else
                isP = false;

        return isP ? 1 : 2;
    }
}