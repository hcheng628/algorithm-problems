package us.supercheng.algorithm.problems.algo.insertionsort;

public class Program {

    public static int[] insertionSort_Solution1(int[] array) {
        for (int i=1, len = array.length; i<len; i++)
            for (int j=0; j<i; j++)
                if (array[i] < array[j])
                    swap(array, i, j);

        return array;
    }

    public static int[] insertionSort_Solution2(int[] array) {
        for (int i=1, len = array.length; i<len; i++)
            for (int j=i; j>0; j--)
                if (array[j-1] > array[j])
                    swap(array, j-1, j);
                else
                    break;

        return array;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
