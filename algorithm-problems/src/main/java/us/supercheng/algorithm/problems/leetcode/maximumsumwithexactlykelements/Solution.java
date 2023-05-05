package us.supercheng.algorithm.problems.leetcode.maximumsumwithexactlykelements;

import java.util.Arrays;

class Solution {

    public int maximizeSum(int[] nums, int k) {
        return k <= 0 ? 0 : ( Arrays.stream(nums).max().getAsInt() * 2 + k - 1) * k / 2;
    }

}