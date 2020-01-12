package us.supercheng.algorithm.problems.minimumtimevisitingallpoints;

public class Solution {

    public int minTimeToVisitAllPoints(int[][] points) {
        int ret = 0;
        for (int i=1, len = points.length;i<len;i++)
            ret += Math.max(Math.abs(points[i][0] - points[i-1][0]), Math.abs(points[i][1] - points[i-1][1]));
        return ret;
    }
}