package us.supercheng.algorithm.algorithm.sorting.basic;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.lang.reflect.Method;

public class SortTestHelper {

    private SortTestHelper(){}

    public static Integer[] generateRandomArray(int n, int lowerBound, int upperBound) {
        assert lowerBound <= upperBound;
        Integer[] arr = new Integer[n];
        for(int i=0;i<n;i++)
            arr[i] = (int) (Math.random() * (upperBound - lowerBound + 1)) + lowerBound ;
        return arr;
    }

    public static void printArray(Object [] arr) {
        for(int i=0;i<arr.length;i++)
            PrintHelper.echo(arr[i] + " ");
        PrintHelper.echoLn("");
    }

    public static boolean isSorted(Comparable[] arr) {
        for(int i=0;i<arr.length-1;i++)
            if(arr[i].compareTo(arr[i+1]) > 0)
                return false;
        return true;
    }

    public static void doTestSort(String sortClassName, Comparable[] arr) throws Exception {
        Class sortClass = Class.forName(sortClassName);
        Method sort = sortClass.getMethod("sort", new Class[] {
                Comparable[].class
        });
        Object[] params = new Object[]{arr};
        long start = System.currentTimeMillis();
        sort.invoke(null, params);
        long end = System.currentTimeMillis();
        assert isSorted(arr);
        PrintHelper.echoLn( sortClass.getSimpleName()+ " : " + (end-start) + "ms" );
    }

}




