package us.supercheng.algorithm.problems.leetcode.validsquare;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        int[][] arr = new int[][]{p1, p2, p3, p4};
        int[] topLeft, topRight, botLeft, botRight;

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        if (arr[3][0] < arr[2][0]) {
            topLeft = arr[3];
            topRight = arr[2];
        } else {
            topLeft = arr[2];
            topRight = arr[3];
        }

        if (arr[1][0] < arr[0][0]) {
            botLeft = arr[1];
            botRight = arr[0];
        } else {
            botLeft = arr[0];
            botRight = arr[1];
        }

        int topLine = Math.abs(topLeft[0] - topRight[0]),
            botLine = Math.abs(botLeft[0] - botRight[0]),
            leftLine = Math.abs(topLeft[1] - botLeft[1]),
            rightLine = Math.abs(topRight[1] - botRight[1]);

        return topLine == botLine && botLine == leftLine && leftLine == rightLine &&
                Math.pow(topLeft[0] - botRight[0], 2) + Math.pow(topLeft[1] - botRight[1], 2) ==
                        Math.pow(topRight[0] - botLeft[0], 2) + Math.pow(topRight[1] - botLeft[1], 2) &&
                topLine * botLine > 0;
    }
}