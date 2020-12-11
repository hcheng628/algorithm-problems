package us.supercheng.algorithm.problems.leetcode.rectangleoverlap;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int [] rec1 = {7,8,13,15};
        int [] rec2 = {10,8,12,20};
        PrintHelper.echoLn(new App().isRectangleOverlap(rec1, rec2));
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean isXInRange,isYInRange;
        isXInRange = isWithinRange(rec2[0], rec2[2], rec1[0], rec1[2]);
        isYInRange = isWithinRange(rec2[1], rec2[3], rec1[1], rec1[3]);
        if(isXInRange && isYInRange)
            return true;
        if(!isXInRange)
            isXInRange = isWithinRange(rec1[0], rec1[2], rec2[0], rec2[2]);
        if(!isYInRange)
            isYInRange = isWithinRange(rec1[1], rec1[3], rec2[1], rec2[3]);
        return isXInRange && isYInRange;
    }

    private boolean isWithinRange(int a, int b, int p1, int p2) {
        if(a>b) {
            if((p1 < a && p1 > b) || (p2 < a && p2 > b))
                return true;
        } else {
            if((p1 < b && p1 > a) || (p2 < b && p2 > a))
                return true;
        }
        return false;
    }

    /*
        isXInRange = isWithinRange(xx1, xx2, x1, x2);
        isYInRange = isWithinRange(yy1, yy2, y1, y2);
        if(isXInRange && isYInRange)
            return true;
        if(!isXInRange)
            isXInRange = isWithinRange(x1, x2, xx1, xx2);
        if(!isYInRange)
            isYInRange = isWithinRange(y1, y2, yy1, yy2);
        return isXInRange && isYInRange;
     */

}