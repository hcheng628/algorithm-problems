package us.supercheng.algorithm.problems.algo.quickselect;

import java.util.*;

public class Program {

    // Time: O(n^2) Avg Time: O(n) Space: O(n)  // Rec Stack
    public static int quickselect(int[] array, int k) {
        return quicksort(array, 0, array.length - 1, k - 1);
    }

    private static int quicksort(int[] arr, int left, int right, int k) {
        if (left >= right)
            return arr[left];

        int r = right;
        for (int  p = left, pVal = arr[p], l = left + 1; l <= r; ) {
            if (arr[l] > pVal && arr[r] < pVal)
                swap(arr, l, r);
            if (arr[l] <= pVal)
                l++;
            if (arr[r] >= pVal)
                r--;
        }
        swap(arr, r, left);
        if (r == k)
            return arr[r];
        return r > k ? quicksort(arr, left, r - 1, k) : quicksort(arr, r + 1, right, k);
    }

    private static void swap(int[] arr, int left, int right) {
        if (left == right)
            return;
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
