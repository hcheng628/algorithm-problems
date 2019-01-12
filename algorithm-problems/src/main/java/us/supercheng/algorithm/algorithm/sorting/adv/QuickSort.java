package us.supercheng.algorithm.algorithm.sorting.adv;

import us.supercheng.algorithm.algorithm.sorting.basic.InsertionSort;
import us.supercheng.algorithm.algorithm.sorting.common.SortTestHelper;
import us.supercheng.algorithm.common.helper.ArrayHelper;
import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Arrays;

public class QuickSort {

    private QuickSort(){}

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length-1);
    }

    private static void sort(Comparable[] arr, int left, int right) {
        if(right - left < 16) {
            InsertionSort.sort(arr, left, right+1);
            return;
        }

        if(left >= right)
            return;
        int pivot = partition(arr, left, right);
        //PrintHelper.echoLn("left: " + left + " pivot: " + pivot + " right: " + right);
        sort(arr, left, pivot-1);
        sort(arr, pivot+1, right);
    }

    private static int partition(Comparable[] arr, int left, int right) {
        ArrayHelper.swap(arr, left, (int)(Math.random() * (right - left + 1)) + left);
        int low = left + 1,
            high = right;
        while(true) {
            while(low <= right && arr[low].compareTo(arr[left]) < 0)
                low++;
            while(high > left && arr[high].compareTo(arr[left]) > 0)
                high--;
            if(low > high)
                break;
            ArrayHelper.swap(arr, low++, high--);
        }
        ArrayHelper.swap(arr, left, high);
        return high;
    }

    public static void main(String[] args) throws Exception {
        int N = 1000000,
                LOWER_BOUND = -20000,
                UPPER_BOUND = 20000,
                SWAP_TIMES = 100;

        Integer[] arr = SortTestHelper.generateRandomArray(N, LOWER_BOUND, UPPER_BOUND),
                arrCopy = Arrays.copyOf(arr, arr.length);
        //Integer [] arr = {3, 11, 6, 1, 17, 0, 15, 13, 7, 9};
        SortTestHelper.doTestSort(new QuickSort().getClass().getName(), arr);
        SortTestHelper.doTestMethod(new MergeSort().getClass().getName(), "sortTD", arrCopy);

        // Nearly Sorted
        arr = SortTestHelper.generateNearlySortedArray(N, SWAP_TIMES);
        arrCopy = Arrays.copyOf(arr, arr.length);
        SortTestHelper.doTestSort(new QuickSort().getClass().getName(), arr);
        SortTestHelper.doTestMethod(new MergeSort().getClass().getName(), "sortTD", arrCopy);
    }
}