package us.supercheng.algorithm.problems.algo.quicksort;

public class Program {

    public static int[] quickSort(int[] array) {
        helper(array, 0, array.length - 1);
        return array;
    }

    private static void helper(int[] arr, int left, int right) {
        if (left >= right)
            return;

        int r = right;
        for (int l = left + 1, pVal = arr[left]; l <= r; ) {
            if (arr[l] > pVal && arr[r] < pVal)
                swap(arr, l, r);

            if (arr[l] <= pVal)
                l++;

            if (arr[r] >= pVal)
                r--;
        }

        swap(arr, left, r);
        helper(arr, left, r - 1);
        helper(arr, r + 1, right);
    }

    private static void swap(int[] arr, int left, int right) {
        if (left == right)
            return;
        int tmpVal = arr[left];
        arr[left] = arr[right];
        arr[right] = tmpVal;
    }

}
// [8, 5, 2, 9, 5, 6, 3]