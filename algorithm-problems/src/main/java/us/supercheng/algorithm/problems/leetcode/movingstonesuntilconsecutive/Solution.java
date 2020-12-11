package us.supercheng.algorithm.problems.leetcode.movingstonesuntilconsecutive;

class Solution {

    public int[] numMovesStones(int a, int b, int c) {
        int min = Math.min(Math.min(a, b), c),
                max = Math.max(Math.max(a, b), c),
                mid = (a + b + c) - max - min,
                left = mid - min,
                right = max - mid;

        return (mid-min == 1 && max-mid == 1) ? new int [] {0, 0} :
                new int [] {left < 3 || right < 3 ? 1 : 2, max - min - 2};
    }
}