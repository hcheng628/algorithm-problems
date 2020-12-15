package us.supercheng.algorithm.problems.algo.binarysearch;

import java.util.*;

public class Program {

    public static int binarySearch_Solution1(int[] array, int target) {
        int len = array.length,
                left = 0,
                right = len - 1;

        return binarySearch_Solution1(array, target, left, right, len);
    }

    public static int binarySearch_Solution1(int[] array, int target, int left, int right, int len) {
        if (left > right)
            return -1;

        int idx = (right - left) / 2 + left,
                val = array[idx];

        if (val == target)
            return idx;
        else if (val > target)
            return binarySearch_Solution1(array, target, left, idx - 1, len);
        else
            return binarySearch_Solution1(array, target, idx + 1, right, len);
    }

    public static int binarySearch_Solution2(int[] array, int target) {
        int len = array.length,
            left = 0,
            right = len - 1;

        while (left <= right) {
            int idx = (right - left) / 2 + left,
                val = array[idx];

            if (val == target)
                return idx;
            else if (val < target)
                left = idx + 1;
            else
                right = idx - 1;
        }

        return -1;
    }

}
