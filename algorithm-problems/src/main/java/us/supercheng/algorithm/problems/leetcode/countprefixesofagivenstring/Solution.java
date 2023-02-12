package us.supercheng.algorithm.problems.leetcode.countprefixesofagivenstring;

import java.util.Arrays;

class Solution {

    public int countPrefixes(String[] words, String s) {
        int ret = 0;

        for (String w : words)
            if (s.startsWith(w))
                ret++;

        return ret;
    }

    public int countPrefixes1Liner(String[] words, String s) {
        return (int) Arrays.stream(words).filter( w -> s.startsWith(w)).count();
    }

}
