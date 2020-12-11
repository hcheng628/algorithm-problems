package us.supercheng.algorithm.problems.leetcode.mycalendari;

import java.util.TreeMap;

public class MyCalendar {

    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        this.map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (start < 0 || end < 0 || start >= end)
            return false;

        Integer prevStart = this.map.floorKey(start),
                nextStart = this.map.ceilingKey(start);
        if ((nextStart != null && end > nextStart) || (prevStart != null && this.map.get(prevStart) > start))
            return false;

        this.map.put(start, end);
        return true;
    }

    public boolean bookCount(int start, int end) {
        if (start < 0 || end < 0 || start >= end)
            return false;

        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int count = 0;
        for (int val : map.values()) {
            count += val;
            if (count > 1) {
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                return false;
            }
        }
        return true;
    }
}
