package us.supercheng.algorithm.problems.leetcode.mergesimilaritems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {

    public List<List<Integer>> mergeSimilarItemsSort(int[][] items1, int[][] items2) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(items1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(items2, Comparator.comparingInt(a -> a[0]));

        for (int i = 0, j = 0, l1 = items1.length, l2 = items2.length; i < l1 || j < l2; )
            if (i < l1 && j < l2)
                if (items1[i][0] == items2[j][0])
                    ret.add(Arrays.asList(items1[i][0], items1[i++][1] + items2[j++][1]));
                else if (items1[i][0] < items2[j][0])
                    ret.add(Arrays.asList(items1[i][0], items1[i++][1]));
                else
                    ret.add(Arrays.asList(items2[j][0], items2[j++][1]));
            else if (i < l1)
                ret.add(Arrays.asList(items1[i][0], items1[i++][1]));
            else
                ret.add(Arrays.asList(items2[j][0], items2[j++][1]));

        return ret;
    }

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ret = new ArrayList<>();
        int[] count = new int[1001];

        for (int[] item : items1)
            count[item[0]] += item[1];
        for (int[] item : items2)
            count[item[0]] += item[1];

        for (int i = 1; i < 1001; i++)
            if (count[i] > 0)
                ret.add(Arrays.asList(i, count[i]));

        return ret;
    }

}
