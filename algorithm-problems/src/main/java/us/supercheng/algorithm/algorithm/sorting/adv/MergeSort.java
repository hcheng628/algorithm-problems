package us.supercheng.algorithm.algorithm.sorting.adv;

import us.supercheng.algorithm.algorithm.sorting.basic.InsertionSort;
import us.supercheng.algorithm.algorithm.sorting.common.SortTestHelper;
import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Arrays;

public class MergeSort {
    private static int INSERTIONSORT_THRESHOLD = 15;

    public static void sortTD(Comparable [] arr) {
        Comparable[] aux = new Comparable[arr.length];
        sortTD(arr, aux, 0, arr.length-1);
    }

    public static void sortTD(Comparable[] arr, Comparable[] aux, int left, int right) {
        if(left >= right)
            return;

        if(right - left <= INSERTIONSORT_THRESHOLD ) {
            InsertionSort.sort(arr, left, right+1);
            return;
        }

        int mid = (right - left) / 2 + left;
        sortTD(arr, aux, left, mid);
        sortTD(arr, aux, mid+1, right);
        if(arr[mid].compareTo(arr[mid+1]) > 0)
            merge(arr, aux, left, mid, right);
    }

    public static void sortBU(Comparable [] arr) {
        Comparable[] aux = new Comparable[arr.length];
        for(int i=0;i<arr.length;i+=16)
            InsertionSort.sort(arr, i, Math.min(i+16, arr.length));

        for(int i=16;i<arr.length;i *=2)
            for(int j=0;j+i<arr.length;j += 2*i)
                if(arr[j+i-1].compareTo(arr[j+i]) > 0)
                    merge(arr, aux, j, j+i-1, j+i*2 > arr.length ? arr.length -1 : j+i*2-1);
    }


    private static void merge(Comparable[] arr, Comparable[] aux, int left, int mid, int right) {
        //PrintHelper.echoLn("******* Merge left: " + left + " mid: " + mid + "  right: " + right);
        int lIndex = left,
            rIndex = mid+1;

        for(int i=left;i<=right;i++) {
            if(lIndex > mid)
                aux[i] = arr[rIndex++];
            else if (rIndex > right)
                aux[i] = arr[lIndex++];
            else if (arr[lIndex].compareTo(arr[rIndex]) < 0)
                aux[i] =  arr[lIndex++];
            else
                aux[i] = arr[rIndex++];
        }

        for(int i=left;i<=right;i++)
            arr[i] = aux[i];
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) throws Exception {
        int N = 200000,
            LOWER_BOUND = 0,
            UPPER_BOUND = 10000;

        Integer[] arr = SortTestHelper.generateRandomArray(N, LOWER_BOUND, UPPER_BOUND),
                  arrCopy = Arrays.copyOf(arr, arr.length);
        try {
            SortTestHelper.doTestMethod(new MergeSort().getClass().getName(), "sortTD", arr);
            SortTestHelper.doTestMethod(new MergeSort().getClass().getName(), "sortBU", arrCopy);
        } catch (Exception ex){
            PrintHelper.echoLn("\r\n!!!!!!\r\n" + ex + "\r\n!!!!!!\r\n");
        }
    }
}