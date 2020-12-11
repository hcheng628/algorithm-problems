package us.supercheng.algorithm.problems.leetcode.minimumnumberofarrowstoburstballoons;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length < 1)
            return 0;

        Arrays.sort(points, new Comparator<int []>() {
            public int compare(int[] a, int [] b) {
                return a[1] - b[1];
            }
        });

        int len = points.length,
                shoots = 1,
                curr = points[0][1];

        for (int i=1;i<len;i++)
            if (points[i][0] > curr) {
                shoots++;
                curr = points[i][1];
            }

        return shoots;
    }
}