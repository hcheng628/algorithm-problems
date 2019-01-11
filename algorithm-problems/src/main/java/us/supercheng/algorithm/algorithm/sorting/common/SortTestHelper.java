package us.supercheng.algorithm.algorithm.sorting.common;

import us.supercheng.algorithm.common.helper.ArrayHelper;
import us.supercheng.algorithm.common.helper.PrintHelper;
import java.lang.reflect.Method;
import java.util.Arrays;

public class SortTestHelper {

    private SortTestHelper(){}

    public static Integer[] generateRandomArray(int n, int lowerBound, int upperBound) {
        assert lowerBound <= upperBound;
        Integer[] arr = new Integer[n];
        for(int i=0;i<n;i++)
            arr[i] = (int) (Math.random() * (upperBound - lowerBound + 1)) + lowerBound ;
        return arr;
    }

    public static Integer[] generateNearlySortedArray(int n, int swapTimes) {
        Integer[] arr = generateRandomArray(n,-n, n);
        Arrays.sort(arr);
        for(int i=0;i<swapTimes;i++)
            ArrayHelper.swap(arr, (int)(Math.random() * n), (int)(Math.random() * n));
        return arr;
    }

    public static void printArray(Object [] arr) {
        for(int i=0;i<arr.length;i++)
            PrintHelper.echo(arr[i] + " ");
        PrintHelper.echoLn("");
    }

    public static boolean isSorted(Comparable[] arr) {
        return isSorted(arr, 0, arr.length);
    }

    public static boolean isSorted(Comparable[] arr, int left, int right) {
        for(int i=left;i<right-1;i++)
            if(arr[i].compareTo(arr[i+1]) > 0) {
                PrintHelper.echoLn("Not sorted @ " + i + "[" + arr[i] + "]");
                return false;
            }
        return true;
    }

    public static void doTestSort(String sortClassName, Comparable[] arr) throws Exception {
        doTestMethod(sortClassName, "sort", arr);
    }

    public static void doTestMethod(String sortClassName, String methodName, Comparable[] arr) throws Exception {
        Class sortClass = Class.forName(sortClassName);
        Method sort = sortClass.getMethod(methodName, new Class[] {
                Comparable[].class
        });
        PrintHelper.echoLn(sortClassName + " method: " + methodName);
        Object[] params = new Object[]{arr};
        long start = System.currentTimeMillis();
        sort.invoke(null, params);
        long end = System.currentTimeMillis();
        PrintHelper.echoLn( sortClass.getSimpleName()+ " method: " + methodName + " : " + (end-start) + "ms" );
        if(!isSorted(arr))
            throw new RuntimeException("!!!!!! Not Sorted Method: " + methodName + "!!!!!!");
    }
}