package us.supercheng.algorithm.problems.leetcode.percentageofletterinstring;

class Solution {

    public int percentageLetter(String s, char letter) {
        return (int) (s.chars().filter(c -> Character.valueOf((char) c) == letter).count() / (1.0 * s.length()) * 100.0);
    }

}
