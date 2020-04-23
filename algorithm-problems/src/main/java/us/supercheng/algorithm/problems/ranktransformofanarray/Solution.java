package us.supercheng.algorithm.problems.ranktransformofanarray;

import java.util.*;

public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] ret = new int[arr.length];

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : arr)
            set.add(a);

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        for (int i=0, len=list.size(); i<len; i++)
            map.put(list.get(i), i+1);

        for (int i=0, len=arr.length; i<len; i++)
            ret[i] = map.get(arr[i]);

        return ret;
    }
}