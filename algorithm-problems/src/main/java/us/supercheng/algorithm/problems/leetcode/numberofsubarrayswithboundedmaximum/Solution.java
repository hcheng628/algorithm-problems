package us.supercheng.algorithm.problems.leetcode.numberofsubarrayswithboundedmaximum;

public class Solution {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int len = A.length,
            ret = 0;

        for (int i=0;i<len;i++)
            if (A[i] <= R) {
                int max = A[i];
                for (int j=i;j<len;j++) {
                    if (A[j] > R)
                        break;

                    max = Math.max(max, A[j]);
                    if (max >= L)
                        ret++;
                }
            }

        return ret;
    }
}