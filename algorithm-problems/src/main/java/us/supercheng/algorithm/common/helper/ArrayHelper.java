package us.supercheng.algorithm.common.helper;

public class ArrayHelper {

    public static void echo(int[] arr) {
        for(int k=0;k<arr.length;k++)
            PrintHelper.echo(k == arr.length-1? arr[k] : arr[k] + ",");
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
}