package us.supercheng.algorithm.problems.leetcode.hindex;

import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        int [] bucket = new int [citations.length+1];
        for (int i=0;i<citations.length;i++)
            bucket[citations[i] < citations.length ? citations[i] : citations.length]++;

        for (int sum = 0, ret = citations.length;ret>0;ret--) {
            sum += bucket[ret];
            if (sum >= ret)
                return ret;
        }

        return 0;
    }

    public int hIndex2(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        int ret = citations.length;

        Arrays.sort(citations);

        for (int i=0;i<citations.length;i++)
            if (citations[i] >= citations.length - i)
                return citations.length - i;

        return 0;
    }
}