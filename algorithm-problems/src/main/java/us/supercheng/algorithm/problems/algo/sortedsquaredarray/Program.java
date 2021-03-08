package us.supercheng.algorithm.problems.algo.sortedsquaredarray;

import java.util.Arrays;
import java.util.Comparator;

public class Program {

    // Time: O(n) Space: O(n)
    public int[] sortedSquaredArray(int[] array) {
        int len = array.length;
        int[] ret = new int[len];

        for (int left = 0, right = len - 1, idx = right; left <= right; idx--) {
            int leftRes = array[left] * array[left];
            int rightRes = array[right] * array[right];

            if (leftRes > rightRes) {
                ret[idx] = leftRes;
                left++;
            } else {
                ret[idx] = rightRes;
                right--;
            }
        }

        return ret;
    }

    // Time: O(nlog(n)) Space: O(n)
    public int[] sortedSquaredArray_Solution2(int[] array) {
        int len = array.length;
        Integer[] arr = new Integer[len];

        for (int i=0; i<len; i++)
            arr[i] = array[i];

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        for (int i=0; i<len; i++)
            array[i] = arr[i] * arr[i];

        return array;
    }

}
