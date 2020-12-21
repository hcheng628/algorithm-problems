package us.supercheng.algorithm.problems.algo.selectionsort;

public class Program {

    public static int[] selectionSort(int[] array) {
        for (int i=0, len=array.length; i<len; i++) {
            int minIdx = i;

            for (int j=i+1; j<len; j++)
                if (array[j] < array[minIdx])
                    minIdx = j;

            if (array[minIdx] != array[i])
                swap(array, minIdx, i);
        }

        return array;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
