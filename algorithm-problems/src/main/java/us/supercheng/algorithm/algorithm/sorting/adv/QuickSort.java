package us.supercheng.algorithm.algorithm.sorting.adv;

import us.supercheng.algorithm.algorithm.sorting.common.SortTestHelper;
import us.supercheng.algorithm.common.helper.ArrayHelper;
import us.supercheng.algorithm.common.helper.PrintHelper;
import us.supercheng.algorithm.common.helper.ThreadHelper;
import java.util.Arrays;

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
        int lessIndex = left;
        for(int i=left+1;i<=right;i++)
            if(arr[i].compareTo(arr[left]) < 0)
                ArrayHelper.swap(arr, ++lessIndex, i);
        ArrayHelper.swap(arr, lessIndex, left);
        return lessIndex;
    }

    public static void main(String[] args) throws Exception {
        int N = 100000,
                LOWER_BOUND = 0,
                UPPER_BOUND = 200000;

        Integer[] arr = SortTestHelper.generateRandomArray(N, LOWER_BOUND, UPPER_BOUND),
                arrCopy = Arrays.copyOf(arr, arr.length);
        //Integer [] arr = {3, 11, 6, 1, 17, 0, 15, 13, 7, 9};
        SortTestHelper.doTestSort(new QuickSort().getClass().getName(), arr);
        SortTestHelper.doTestMethod(new MergeSort().getClass().getName(), "sortTD", arrCopy);
    }
}