package us.supercheng.algorithm.common.helper;

public class ArrayHelper {

    public static void echo(Object [] arr) {
        for(int i=0;i<arr.length;i++)
            PrintHelper.echo(i == arr.length-1? arr[i] : arr[i] + ",");
        PrintHelper.echoLn("");
    }

    public static void swap(Comparable[] arr, int i, int j) {
        if(arr == null || arr.length < 2 || i == j)
            return;
        int lastIndex = arr.length-1;
        if(i<0 || i>lastIndex || j<0 || j>lastIndex)
            throw new IllegalArgumentException("Invalid Index");
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
}