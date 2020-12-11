package us.supercheng.algorithm.problems.leetcode.sumofsubarrayminimums;

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

    public int sumSubarrayMins(int[] A) {
        int ret = 0;

        for (int i=0, len = A.length; i<len; i++) {
            int l = 0,
                r = 0;

            for (int idx=i-1; idx>-1 && A[idx]>A[i]; idx--)
                l++;
            for (int idx=i+1; idx<len && A[idx] >=A[i]; idx++)
                r++;

            ret = (ret + (++r) * (++l) * A[i]) % 1000000007;
        }

        return ret;
    }

    public int sumSubarrayMinsOPT(int[] A) {
        int len = A.length;
        long ret = 0;
        int[] leftCount = new int[len],
              rightCount = new int[len];

        for (int i=0; i<len; i++) {
            int count = 1;
            for (int j = i - 1; j>=0 && A[j]>=A[i]; j -= leftCount[j])
                count += leftCount[j];
            leftCount[i] = count;
        }

        for (int i=len-1; i>=0; i--) {
            int count = 1;
            for (int j = i + 1; j<len && A[j]>A[i]; j += rightCount[j])
                count += rightCount[j];
            rightCount[i] = count;
        }

        for (int i = 0; i< len; i++)
            ret += A[i] * leftCount[i] * rightCount[i];

        return (int) (ret % 1000000007);
    }
}