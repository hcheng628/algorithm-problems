package us.supercheng.algorithm.problems.leetcode.mycalendarii;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendarTwo {

    List<int[]> list;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        this.list = new ArrayList<>();
        this.overlaps = new ArrayList<>();

        this.map = new TreeMap<>();// count approach for bookCount method
    }

    public boolean book(int start, int end) {
        if (start < 0 || end < 0 || start >= end)
            return false;

        for (int[] overlap : overlaps) {
            if (end > overlap[0] && start < overlap[1]) {
                return false;
            }
        }


        for (int[] each : list) {
            if (end > each[0] && start < each[1]) {
                overlaps.add(new int[]{Math.max(start, each[0]), Math.min(end, each[1])});
            }
        }

        this.list.add(new int[]{start, end});
        return true;
    }

    TreeMap<Integer, Integer> map;

    public boolean bookCount(int start, int end) {
        if (start < 0 || end < 0 || start >= end)
            return false;

        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int count = 0;
        for (int val : map.values()) {
            count += val;
            if (count > 2) {
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                return false;
            }
        }
        return true;
    }
}
