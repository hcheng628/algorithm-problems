package us.supercheng.algorithm.problems.algo.shiftedbinarysearch;

import java.util.Arrays;

public class Program {

    public static int shiftedBinarySearch(int[] array, int target) {
        for (int len = array.length, left = 0, right = len - 1; left < right; ) {
            int mid = (right - left) / 2 + left;
            int leftVal = array[left];
            int midVal = array[mid];
            int rightVal = array[right];

            if (midVal == target)
                return mid;
            else if (midVal == target)
                return mid;
            else if (rightVal == target)
                return right;

            if (midVal >= leftVal)
                if (target > leftVal && target < midVal)
                    right = mid - 1;
                else
                    left = mid + 1;
            else
                if (target > midVal && target < rightVal)
                    left = mid + 1;
                else
                    right = mid - 1;
        }

        return -1;
    }

}
