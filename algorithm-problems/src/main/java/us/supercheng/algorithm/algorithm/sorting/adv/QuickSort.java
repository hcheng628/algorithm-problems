package us.supercheng.algorithm.algorithm.sorting.adv;

import us.supercheng.algorithm.algorithm.sorting.common.SortTestHelper;
import us.supercheng.algorithm.common.helper.ArrayHelper;
import us.supercheng.algorithm.common.helper.PrintHelper;
import us.supercheng.algorithm.common.helper.ThreadHelper;

public class QuickSort {

    private QuickSort(){}

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length-1);
    }

    private static void sort(Comparable[] arr, int left, int right) {
        if(left >= right)
            return;
        int pivot = partition(arr, left, right);
        //PrintHelper.echoLn("left: " + left + " pivot: " + pivot + " right: " + right);
        sort(arr, left, pivot-1);
        sort(arr, pivot+1, right);
    }

    private static int partition(Comparable[] arr, int left, int right) {

        return -1;
    }

    public static void main(String[] args) throws Exception {
        int N = 10,
                LOWER_BOUND = 0,
                UPPER_BOUND = 20;

//        Integer[] arr = SortTestHelper.generateRandomArray(N, LOWER_BOUND, UPPER_BOUND),
//                arrCopy = Arrays.copyOf(arr, arr.length);
        Integer [] arr = {3, 11, 6, 1, 17, 0, 15, 13, 7, 9};
        SortTestHelper.printArray(arr);
        QuickSort.sort(arr);
        SortTestHelper.printArray(arr);
    }
}