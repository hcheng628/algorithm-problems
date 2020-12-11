package us.supercheng.algorithm.problems.leetcode.findluckyintegerinanarray;

public class Solution {

    public int findLucky(int[] arr) {
        int[] bucket = new int [501];

        for (int a : arr)
            bucket[a]++;

        for (int val=500; val>-1; val--)
            if (val == bucket[val] && bucket[val] > 0)
                return val;

        return -1;
    }
}