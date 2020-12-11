package us.supercheng.algorithm.problems.leetcode.heightchecker;

import java.util.Arrays;

class Solution {

    public int heightChecker(int[] heights) {
        if (heights == null || heights.length < 2)
            return 0;

        int ret = 0,
            len = heights.length;

        int[] copyHeights = Arrays.copyOf(heights, len);

        Arrays.sort(copyHeights);

        for (int i=0;i<len;i++)
            if (heights[i] != copyHeights[i])
                ret++;

        return ret;
    }
}