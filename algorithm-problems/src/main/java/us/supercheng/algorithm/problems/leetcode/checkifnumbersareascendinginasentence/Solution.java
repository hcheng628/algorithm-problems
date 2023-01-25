package us.supercheng.algorithm.problems.leetcode.checkifnumbersareascendinginasentence;

public class Solution {

    public boolean areNumbersAscending(String s) {
        Integer prev = null;

        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                for (; i + 1 < len && Character.isDigit(s.charAt(i + 1)); i++)
                    num = (num * 10) + (s.charAt(i + 1) - '0');

                if (prev != null && num <= prev)
                    return false;

                prev = num;
            }
        }

        return true;
    }

}
