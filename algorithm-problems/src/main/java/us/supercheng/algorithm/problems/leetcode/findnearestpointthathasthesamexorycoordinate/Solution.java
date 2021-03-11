package us.supercheng.algorithm.problems.leetcode.findnearestpointthathasthesamexorycoordinate;

public class Solution {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int ret = -1;
        int dis = -1;

        for (int i=0, len=points.length; i<len; i++)
            if (points[i][0] == x || points[i][1] == y) {
                int curr = this.calDis(x, y, points[i][0], points[i][1]);
                if (dis == -1 || curr < dis) {
                    dis = curr;
                    ret = i;
                }
            }

        return ret;
    }

    private int calDis(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}