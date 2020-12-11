package us.supercheng.algorithm.problems.leetcode.queuereconstructionbyheight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[0] != b[0]) ? b[0] - a[0]: a[1] - b[1];
            }
        });

        List<int[]> list = new ArrayList<>();

        for (int[] each : people)
            list.add(each[1], each);

        return list.toArray(new int[people.length][2]);
    }
}