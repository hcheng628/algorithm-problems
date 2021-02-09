package us.supercheng.algorithm.problems.algo.waterarea;

import java.util.*;

public class Program {

    public static int waterArea(int[] heights) {
        int ret = 0;

        for (int i=1, len = heights.length; i<len-1; i++) {
            int left = findMaxP(heights, i, 1);
            int right = findMaxP(heights, i, -1);
            int height = heights[i];
            if (left != -1 && right != -1) {
                int min = Math.min(heights[left], heights[right]);
                if (min > height) {
                    ret += min - height;
                }
            }
        }

        return ret;
    }

    private static int findMaxP(int[] arr, int idx, int dir) {
        int start = idx + dir;

        if (start < -1 || start >= arr.length)
            return -1;

        int ret = start;
        int max = arr[start];
        while (start >= 0 && start < arr.length) {
            if (arr[start] > max) {
                ret = start;
                max = arr[start];
            }
            start += dir;
        }

        return ret;
    }

    public static int waterArea_Solution2(int[] heights) {
        if (heights == null || heights.length < 3)
            return 0;

        int ret = 0;
        int len = heights.length;
        int[] dpLeft = new int[len];
        int[] dpRight = new int[len];

        dpLeft[0] = heights[0];
        dpRight[len - 1] = heights[len - 1];
        for (int i=1, j=len - 2; i<len; i++, j--) {
            dpLeft[i] = Math.max(dpLeft[i - 1], heights[i]);
            dpRight[j] = Math.max(dpRight[j + 1], heights[j]);
        }

        for (int i=1; i<len-1; i++) {
            int minMax = Math.min(dpLeft[i], dpRight[i]);
            if (heights[i] < minMax)
                ret += minMax - heights[i];
        }

        return ret;
    }

}

