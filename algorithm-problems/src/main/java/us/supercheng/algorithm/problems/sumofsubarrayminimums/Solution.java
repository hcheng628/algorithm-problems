package us.supercheng.algorithm.problems.sumofsubarrayminimums;

public class Solution {

    public int sumSubarrayMinsTLE(int[] A) {
        long ret = 0;

        for (int i=0, len = A.length; i<len; i++)
            for (int j=i; j<len; j++)
                ret = (ret % 1000000007) + this.helper(A, i, j) ;

        return (int) ret;
    }

    private int helper(int[] A, int from, int to) {
        int min = A[from++];

        for (; from<=to; from++)
            min = Math.min(min, A[from]);

        return min;
    }
}