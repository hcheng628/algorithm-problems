package us.supercheng.algorithm.problems.leetcode.validboomerang;

class Solution {

    public boolean isBoomerang(int[][] points) {
        int dx1 = points[0][0] - points[1][0],
                dy1 = points[0][1] - points[1][1],
                dx2 = points[1][0] - points[2][0],
                dy2 = points[1][1] - points[2][1];

        return dx2 * dy1 != dx1 * dy2;
    }
}