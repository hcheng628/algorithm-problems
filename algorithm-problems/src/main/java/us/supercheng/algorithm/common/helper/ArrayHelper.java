package us.supercheng.algorithm.common.helper;

public class ArrayHelper {

    public static void echo(int[] arr) {
        for(int k=0;k<arr.length;k++)
            System.out.print(k == arr.length-1? arr[k] : arr[k] + ",");
    }
}