package us.supercheng.algorithm.algorithm.sorting.adv;

import us.supercheng.algorithm.algorithm.sorting.common.SortTestHelper;
import us.supercheng.algorithm.common.helper.ArrayHelper;
import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Arrays;

public class HeapSort {

    private HeapSort() {}

    private static void shiftDown(Comparable[] arr, int index, int lastIndex) {
        Comparable v = arr[index];
        while(index*2+1 <= lastIndex) {
            int child = (index * 2) + 1;
            if(child + 1 <= lastIndex && arr[child+1].compareTo(arr[child]) > 0)
                child++;
            if(arr[child].compareTo(v) <= 0)
                break;
            arr[index] = arr[child];
            index = child;
        }
        arr[index] = v;
    }

    public static void sort(Comparable[] arr) {
        int lastIndex = arr.length -1;
        for(int i=arr.length / 2 - 1;i>=0;i--)
            shiftDown(arr, i, lastIndex);

        for(;lastIndex>=0;lastIndex--) {
            ArrayHelper.swap(arr, 0, lastIndex);
            shiftDown(arr, 0, lastIndex-1);
        }
    }

    public static void main(String[] args) {
        int N = 1000009,
                LOWER_BOUND = 0,
                UPPER_BOUND = 200000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, LOWER_BOUND, UPPER_BOUND),
                arrCopy = Arrays.copyOf(arr, arr.length);
        try {
            SortTestHelper.doTestSort(new HeapSort().getClass().getName(), arr);
            SortTestHelper.doTestSort(new HeapSort().getClass().getPackage().getName() + ".QuickSort", arrCopy);
            HeapSort.sort(arr);
        } catch (Exception ex){
            PrintHelper.echoLn("\r\n!!!!!!\r\n" + ex + "\r\n!!!!!!\r\n");
            ex.printStackTrace();
        }
    }
}