package us.supercheng.algorithm.problems.leetcode.summultiples;

import java.util.stream.IntStream;

class Solution {

    public int sumOfMultiples(int n) {
        return IntStream.rangeClosed(0, n).filter(i -> i % 3 == 0 || i % 5 == 0 || i % 7 == 0).sum();
    }

}
