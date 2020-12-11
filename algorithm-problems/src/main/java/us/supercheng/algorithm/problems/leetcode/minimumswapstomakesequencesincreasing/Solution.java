package us.supercheng.algorithm.problems.leetcode.minimumswapstomakesequencesincreasing;

public class Solution {

    int ret = Integer.MAX_VALUE;

    public int minSwap(int[] A, int[] B) {
        this.dfs(A, B, 0, 1);
        return this.ret;
    }

    private void dfs(int[] A, int[] B, int curr, int idx) {
        if (idx >= A.length) {
            if (curr < this.ret)
                this.ret = curr;
            return;
        }

        if (curr >= this.ret)
            return;

        if (A[idx] > A[idx-1] && B[idx] > B[idx-1])
            this.dfs(A, B, curr, idx + 1);

        if (A[idx] > B[idx-1] && B[idx] > A[idx-1]) {
            this.swap(A, B, idx);
            this.dfs(A, B, curr+1, idx+1);
            this.swap(A, B, idx);
        }
    }

    private void swap(int[] A, int[] B, int idx) {
        int temp = A[idx];
        A[idx] = B[idx];
        B[idx] = temp;
    }
}