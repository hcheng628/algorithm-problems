package us.supercheng.algorithm.problems.algo.bubblesort;

public class Program {

    public static int[] bubbleSort_Solution1(int[] array) {
        for (int i=0, len=array.length; i<len; i++) {
            boolean sorted = true;
            for (int j=1; j<len-i; j++)
                if (array[j-1] > array[j]) {
                    swap(array, j-1, j);
                    if (sorted)
                        sorted = false;
                }
            if (sorted)
                break;
        }

        return array;
    }

    public static int[] bubbleSort_Solution2(int[] array) {
        for (int i=0, len=array.length; i<len; i++)
            for (int j=1; j<len-i; j++)
                if (array[j-1] > array[j])
                    swap(array, j-1, j);

        return array;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
