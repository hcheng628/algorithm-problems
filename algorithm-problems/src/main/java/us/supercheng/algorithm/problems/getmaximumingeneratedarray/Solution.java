package us.supercheng.algorithm.problems.getmaximumingeneratedarray;

public class Solution {

    public int getMaximumGenerated(int n) {
        if (n < 1)
            return 0;
        else if (n < 3)
            return 1;

        int ret = 0;
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i=2, idxA = 1, idxB = 1; i<=n; i++) {
            if (i % 2 == 0)
                arr[i] = arr[idxA++];
            else
                arr[i] = arr[idxB++] + arr[idxB];

            if (arr[i] > ret)
                ret = arr[i];
        }

        return ret;
    }
}