package us.supercheng.algorithm.problems.partitionarrayintodisjointintervals;

public class Solution {

    public int partitionDisjoint(int[] A) {
        int len = A.length;
        int[][] arr = new int[len][2];

        arr[0][0] = A[0];
        for (int i=1; i<len; i++)
            arr[i][0] = Math.max(arr[i-1][0], A[i]);

        arr[len-1][1] = A[len-1];
        for (int i=len-2; i>-1; i--)
            arr[i][1] = Math.min(arr[i+1][1], A[i]);

        for (int i=0; i<len-1; i++)
            if (arr[i][0] <= arr[i+1][1])
                return i+1;

        return -1;
    }

    public int partitionDisjointOPT(int[] A) {
        int len = A.length,
            currMax = A[0];
        int[] arrMin = new int[len];

        arrMin[len-1] = A[len-1];
        for (int i=len-2; i>-1; i--)
            arrMin[i] = Math.min(arrMin[i+1], A[i]);

        for (int i=0; i<len-1; i++) {
            currMax = Math.max(currMax, A[i]);
            if (currMax <= arrMin[i+1])
                return i+1;
        }

        return -1;
    }

    public int partitionDisjointGreedy(int[] A) {
        int len = A.length,
            leftMax = A[0],
            currMax = leftMax,
            idx = 0;

        for (int i=0; i<len; i++) {
            currMax = Math.max(A[i], currMax);
            if (leftMax > A[i]) {
                leftMax = currMax;
                idx = i;
            }
        }

        return idx + 1;
    }

}
