package us.supercheng.algorithm.problems.leetcode.fibonaccinumber;

class Solution {

    Integer[] memo;

    public int fib(int N) {
        if (N < 2)
            return N;
        this.memo = new Integer[N+1];
        return this.helper(N);
    }

    private int helper(int N) {
        if (this.memo[N] != null)
            return this.memo[N];
        return this.memo[N] = N < 2 ? N : this.helper(N-1) + this.helper(N-2);
    }
}