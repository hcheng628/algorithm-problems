package us.supercheng.algorithm.problems.leetcode.arithmeticslices;

class Solution {
    int count = 0;
    boolean [][] visited;

    public int numberOfArithmeticSlices(int[] A) {
        this.visited = new boolean[A.length+1][A.length+1];
        this.helper(A, 0, A.length);
        return count;
    }

    private void helper(int[] A, int left, int right) {
        if (this.visited[left][right] || left >= right || right - left < 3)
            return;
        this.visited[left][right] = true;
        this.count += this.calAr(A,left, right);
        this.helper(A, left,right-1);
        this.helper(A, left+1, right);
    }

    private int calAr(int[] A, int left, int right) {
        int diff = A[left+1] - A[left];
        for (int i=left+1;i<right;i++)
            if (A[i] - A[i-1] != diff)
                return 0;
        return 1;
    }
}