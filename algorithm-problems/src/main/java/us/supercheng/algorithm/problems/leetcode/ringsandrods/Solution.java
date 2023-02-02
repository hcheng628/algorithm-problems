package us.supercheng.algorithm.problems.leetcode.ringsandrods;

import java.util.Arrays;

class Solution {

    public int countPoints(String rings) {
        int[] bucket = new int[10];

        for (int i = 0, len = rings.length(); i < len; i += 2) {
            char c = rings.charAt(i);
            if (c == 'R')
                bucket[rings.charAt(i + 1) - '0'] |= 1;   // 001: red(1)
            else if (c == 'G')
                bucket[rings.charAt(i + 1) - '0'] |= 2;   // 010: green(2)
            else
                bucket[rings.charAt(i + 1) - '0'] |= 4;   // 100: blue(4)
        }

        return (int) Arrays.stream(bucket).filter(b -> b == 7).count();    // 111: all colors(7)
    }

}
