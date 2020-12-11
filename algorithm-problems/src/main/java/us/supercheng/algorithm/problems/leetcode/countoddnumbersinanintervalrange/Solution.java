package us.supercheng.algorithm.problems.leetcode.countoddnumbersinanintervalrange;

public class Solution {

    public int countOdds(int low, int high) {
        return high % 2 != 0 && low % 2 != 0 ? (high - low + 1) / 2 + 1 : (high - low + 1) / 2;
    }

}