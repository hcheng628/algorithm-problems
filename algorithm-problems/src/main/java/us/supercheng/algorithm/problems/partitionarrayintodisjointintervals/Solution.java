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

}
