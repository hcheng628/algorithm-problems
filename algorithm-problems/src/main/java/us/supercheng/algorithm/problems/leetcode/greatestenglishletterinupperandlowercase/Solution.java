package us.supercheng.algorithm.problems.leetcode.greatestenglishletterinupperandlowercase;

class Solution {

    public String greatestLetter(String s) {
        boolean[][] count = new boolean[2][26];

        for (char c : s.toCharArray()) {
            boolean isUp = Character.toUpperCase(c) == c;
            count[isUp ? 1 : 0][c - (isUp ? 'A' : 'a')] = true;
        }

        for (int i = 25; i > -1; i--)
            if (count[0][i] && count[1][i])
                return String.valueOf((char) (i + 'A'));

        return "";
    }

}
