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



    public static boolean isSorted(Comparable[] arr) {
        return ArrayHelper.isSorted(arr);
    }

    public static boolean isSorted(Comparable[] arr, int left, int right) {
        return ArrayHelper.isSorted(arr, left, right);
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