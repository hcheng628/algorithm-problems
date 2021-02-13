package us.supercheng.algorithm.problems.algo.mergesort;

public class Program {

    public static int[] mergeSort(int[] array) {
        return helper(array, 0, array.length - 1);
    }

    private static int[] helper(int[] arr, int left, int right) {
        if (right - left == 0)
            return new int[]{arr[left]};
        else if (right - left == 1)
            return new int[]{Math.min(arr[left], arr[right]), Math.max(arr[left], arr[right])};

        int mid = (right - left) / 2 + left;
        int[] l = helper(arr, left, mid);
        int[] r = helper(arr, mid + 1, right);
        int[] ret = new int[right - left + 1];

        for (int idx = 0, idxL = 0, idxR = 0; idx<ret.length; idx++)
            if (idxL < l.length && idxR < r.length)
                ret[idx] = l[idxL] < r[idxR] ? l[idxL++] : r[idxR++];
            else if (idxL < l.length)
                ret[idx] = l[idxL++];
            else if (idxR < r.length)
                ret[idx] = r[idxR++];

        return ret;
    }
}
