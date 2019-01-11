package us.supercheng.algorithm.algorithm.sorting.basic;

import us.supercheng.algorithm.algorithm.sorting.common.SortTestHelper;
import us.supercheng.algorithm.common.entity.Student;
import us.supercheng.algorithm.common.helper.ArrayHelper;
import java.util.Arrays;

public class InsertionSort {

    private InsertionSort(){}

    public static void sortV1(Comparable [] arr) {
        for(int i=1;i<arr.length;i++)
            for(int j=i;j>0 && arr[j].compareTo(arr[j-1])<0;j--)
                ArrayHelper.swap(arr, j, j-1);
    }

    public static void sort(Comparable [] arr) {
        sort(arr, 0, arr.length);
    }

    public static void sort1(Comparable [] arr, int left, int right) {
        for(left=left+1;left<right;left++) {
            Comparable insertObj = arr[left];
            int j=left;
            for(;j>0 && insertObj.compareTo(arr[j-1])<0;j--)
                arr[j] = arr[j-1];
            arr[j] = insertObj;
        }
    }

    public static void sort(Comparable[] arr, int l, int r){
        for(int i=l+1;i<r;i++){
            Comparable e = arr[i];
            int j = i;
            for(;j>l&&arr[j-1].compareTo(e)>0;j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }

    public static void main(String[] args) throws Exception{
        int N = 20000,
            SWAP_TIMES = 100;

        // Normal Case
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000),
                  arrCopy = Arrays.copyOf(arr, arr.length);

        SortTestHelper.doTestSort(new InsertionSort().getClass().getName(), arr);
        SortTestHelper.doTestMethod(new InsertionSort().getClass().getName(), "sortV1", arrCopy);


        // Common Small Range
        arr = SortTestHelper.generateRandomArray(N, 0, 3);
        arrCopy = Arrays.copyOf(arr, arr.length);
        SortTestHelper.doTestSort(new InsertionSort().getClass().getName(), arr);
        SortTestHelper.doTestMethod(new InsertionSort().getClass().getName(), "sortV1", arrCopy);

        // Nearly Sorted
        arr = SortTestHelper.generateNearlySortedArray(N, SWAP_TIMES);
        arrCopy = Arrays.copyOf(arr, arr.length);
        SortTestHelper.doTestSort(new InsertionSort().getClass().getName(), arr);
        SortTestHelper.doTestMethod(new InsertionSort().getClass().getName(), "sortV1", arrCopy);

        Student[] students = new Student[4];
        students[0] = new Student("D",90);
        students[1] = new Student("C",100);
        students[2] = new Student("B",95);
        students[3] = new Student("A",95);
        SortTestHelper.doTestSort(new InsertionSort().getClass().getName(), students);
    }
}