package us.supercheng.algorithm.problems.leetcode.maximumnumberofwordsfoundinsentences;

import java.util.Arrays;

public class Solution {

    public int mostWordsFound(String[] sentences) {
        return Arrays.stream(sentences).map(s -> s.split(" ").length).max(Integer::compareTo).orElse(0);
    }

}
