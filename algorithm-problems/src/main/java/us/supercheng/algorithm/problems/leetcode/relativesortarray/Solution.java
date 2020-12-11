package us.supercheng.algorithm.problems.leetcode.relativesortarray;

import java.util.*;

class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = arr1.length,
            idx = 0;
        int [] ret = new int [len];
        Arrays.sort(arr1);

        for (int each : arr2)
            map.put(each, 0);

        for (int i=0;i<len;i++)
            if (map.containsKey(arr1[i])) {
                map.put(arr1[i], map.get(arr1[i])+1);
                arr1[i] = -1;
            }

        for (int i=0;i<arr2.length;i++) {
            int end = map.get(arr2[i]);
            for (int j=0;j<end;j++)
                ret[idx++] = arr2[i];
        }

        for (int i=0;i<len;i++)
            if (arr1[i] != -1)
                ret[idx++] = arr1[i];

        return ret;
    }
}