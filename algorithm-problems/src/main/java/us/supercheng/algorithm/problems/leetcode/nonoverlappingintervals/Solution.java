package us.supercheng.algorithm.problems.leetcode.nonoverlappingintervals;

import us.supercheng.algorithm.common.entity.Interval;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length < 2)
            return 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int [] dp = new int [intervals.length];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i=0;i<dp.length;i++) {
            for (int j=0;j<i;j++)
                if(intervals[j][1] <= intervals[i][0])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            max = Math.max(dp[i], max);
        }

        return intervals.length - max;
    }

}