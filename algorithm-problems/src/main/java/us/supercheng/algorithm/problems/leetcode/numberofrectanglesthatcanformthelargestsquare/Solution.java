package us.supercheng.algorithm.problems.leetcode.numberofrectanglesthatcanformthelargestsquare;

public class Solution {

    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = Math.min(rectangles[0][0], rectangles[0][1]);
        int ret = 1;

        for (int i=1, len=rectangles.length; i<len; i++) {
            int curr = Math.min(rectangles[i][0], rectangles[i][1]);
            if (curr > maxLen) {
                maxLen = curr;
                ret = 1;
            } else if (curr == maxLen)
                ret++;
        }

        return ret;
    }

}
