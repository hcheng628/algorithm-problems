package us.supercheng.algorithm.problems.smallestrangeii;

import java.util.Arrays;

public class Solution {

    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int len = A.length,
                ret = A[len-1] - A[0];

        for (int i=1; i<len; i++)
            ret = Math.min(ret, Math.max(A[i-1]+K, A[len-1]-K) - Math.min(A[0]+K, A[i]-K));

        return ret;
    }

}
