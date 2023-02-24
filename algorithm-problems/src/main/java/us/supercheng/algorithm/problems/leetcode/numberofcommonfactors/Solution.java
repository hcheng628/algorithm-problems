package us.supercheng.algorithm.problems.leetcode.numberofcommonfactors;

import java.util.stream.IntStream;

class Solution {

    public int commonFactors(int a, int b) {
        return (int) IntStream.rangeClosed(1, Math.min(a, b)).filter(n -> a % n == 0 && b % n == 0).count();
    }

}
