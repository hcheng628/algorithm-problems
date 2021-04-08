package us.supercheng.algorithm.problems.algo.mergeoverlappingintervals;

import java.util.*;


public class Program {

    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int idx = 1, len = intervals.length; idx < len; idx++) {
            int[] curr = list.get(list.size() - 1);
            int[] interval = intervals[idx];

            if (interval[0] <= curr[1])
                curr[1] = Math.max(curr[1], interval[1]);
            else
                list.add(interval);
        }

        return list.toArray(new int[list.size()][]);
    }

}
