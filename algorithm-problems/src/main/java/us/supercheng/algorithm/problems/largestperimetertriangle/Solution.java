package us.supercheng.algorithm.problems.largestperimetertriangle;

import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int ret = Integer.MIN_VALUE;
        for(int i=A.length-3;i>=0;i--)
            if(A[i] + A[i+1] > A[i+2])
                return A[i] + A[i+1] + A[i+2];
        return 0;
    }
}