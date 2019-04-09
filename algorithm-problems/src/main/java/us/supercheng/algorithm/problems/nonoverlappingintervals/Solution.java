package us.supercheng.algorithm.problems.nonoverlappingintervals;

import us.supercheng.algorithm.common.entity.Interval;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval one, Interval theOther) {
                if (one.start != theOther.start)
                    return one.start - theOther.start;
                return one.end - theOther.end;
            }
        });

        return -1;
    }

}