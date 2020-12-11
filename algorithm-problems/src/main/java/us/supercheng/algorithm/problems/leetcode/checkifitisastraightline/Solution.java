package us.supercheng.algorithm.problems.leetcode.checkifitisastraightline;

public class Solution {

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length < 2)
            return true;

        int deltaX = coordinates[0][0] - coordinates[1][0],
                deltaY = coordinates[0][1] - coordinates[1][1];

        for (int i=2, len=coordinates.length;i<len;i++) {
            int deltaCurrX = coordinates[i][0] - coordinates[i-1][0],
                    deltaCurrY = coordinates[i][1] - coordinates[i-1][1];
            if (deltaX * deltaCurrY != deltaY * deltaCurrX)
                return false;
        }

        return true;
    }
}