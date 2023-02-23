package us.supercheng.algorithm.problems.leetcode.smallestevenmultiple;

class Solution {

    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n << 1;
    }

}
