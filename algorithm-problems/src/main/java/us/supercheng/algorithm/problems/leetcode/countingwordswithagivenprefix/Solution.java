package us.supercheng.algorithm.problems.leetcode.countingwordswithagivenprefix;

import java.util.Arrays;

class Solution {

    public int prefixCount(String[] words, String pref) {
        return (int) Arrays.stream(words).filter(w -> w.indexOf(pref) == 0).count();
    }

}
