package us.supercheng.algorithm.problems.leetcode.minimumabsolutedifference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        if (arr == null || arr.length < 2)
            return new ArrayList<>();

        List<List<Integer>> ret = new ArrayList<>();

        Arrays.sort(arr);
        int len = arr.length,
                min = Integer.MAX_VALUE;

        for (int i=1;i<len;i++)
            min = Math.min(arr[i] - arr[i-1], min);

        for (int i=1;i<len;i++)
            if (arr[i]-arr[i-1] == min) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[i-1]);
                list.add(arr[i]);
                ret.add(list);
            }

        return ret;
    }
}