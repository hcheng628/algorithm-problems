package us.supercheng.algorithm.problems.algo.nextgreaterelement;

public class Program {

    // Time: O(n^2) Space: O(n)
    public int[] nextGreaterElement_Solution1(int[] array) {
        if (array == null)
            return new int[0];

        int len = array.length;
        int[] ret = new int[len];
        for (int i=0; i<len; i++)
            ret[i] = this.nextBigVal(array, len, i);

        return ret;
    }

    public int nextBigVal(int[] arr, int len, int idx) {
        int currVal = arr[idx];

        for (int i=idx+1; i<len; i++)
            if (arr[i] > currVal)
                return arr[i];

        for (int i=0; i<idx; i++)
            if (arr[i] > currVal)
                return arr[i];

        return -1;
    }

    // Time: O() Space: O()
    public int[] nextGreaterElement(int[] array) {
        return null;
    }
}
