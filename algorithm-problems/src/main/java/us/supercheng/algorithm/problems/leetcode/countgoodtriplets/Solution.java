package us.supercheng.algorithm.problems.leetcode.countgoodtriplets;

public class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ret = 0;

        for (int i=0, len=arr.length; i<len; i++)
            for (int j=i+1; j<len; j++) {
                if (Math.abs(arr[i] - arr[j]) > a)
                    continue;
                for (int k=j+1; k<len; k++)
                    if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c)
                        ret++;
            }

        return ret;
    }
}