package us.supercheng.algorithm.problems.leetcode.categorizeboxaccordingtocriteria;

import java.util.Arrays;

class Solution {

    public String categorizeBox(int length, int width, int height, int mass) {
        boolean heavy = mass >= 100;
        boolean bulky = Math.max(Math.max(length, width), height) >= 10_000 ||
                (length * 1l * width * height) >= 1_000_000_000;

        if (heavy && bulky)
            return "Both";
        else if (heavy)
            return "Heavy";
        return bulky ? "Bulky" : "Neither";
    }

}
