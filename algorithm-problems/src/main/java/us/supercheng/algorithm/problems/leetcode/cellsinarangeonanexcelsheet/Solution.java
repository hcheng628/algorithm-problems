package us.supercheng.algorithm.problems.leetcode.cellsinarangeonanexcelsheet;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> cellsInRange(String s) {
        List<String> ret = new ArrayList<>();

        for (int c = s.charAt(0) - 'A', cEnd = s.charAt(3) - 'A'; c <= cEnd; c++)
            for (int r = s.charAt(1) - '0', rEnd = s.charAt(4) - '0'; r <= rEnd; r++)
                ret.add(String.join("", String.valueOf((char) (c + 'A')), String.valueOf(r)));

        return ret;
    }

}