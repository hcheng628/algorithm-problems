package us.supercheng.algorithm.problems.algo.arrayofproducts;

public class Program {

    public int[] arrayOfProducts_Solution1(int[] array) {
        int len = array.length;
        int[] ret = new int[len];

        for (int i=0; i<len; i++)
            ret[i] = this.cal(array, len, i - 1, -1) * this.cal(array, len, i + 1, 1);

        return ret;
    }

    private int cal(int[] arr, int len, int idx, int inc) {
        return idx == len || idx < 0 ? 1 : arr[idx] * this.cal(arr, len, idx + inc, inc);
    }

    public int[] arrayOfProducts_Solution2(int[] array) {
        int len = array.length;
        int[] left = new int[len],
              right = new int[len],
              ret = new int[len];

        left[0] = array[0];
        for (int i=1; i<len; i++)
            left[i] = array[i] * left[i-1];

        right[len-1] = array[len-1];
        for (int i=len-2; i>-1; i--)
            right[i] = array[i] * right[i+1];

        ret[0] = right[1];
        ret[len-1] = left[len-2];
        for (int i=1; i<len-1; i++)
            ret[i] = left[i-1] * right[i+1];

        return ret;
    }

}