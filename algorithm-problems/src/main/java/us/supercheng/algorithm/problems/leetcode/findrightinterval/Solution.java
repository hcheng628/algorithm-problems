package us.supercheng.algorithm.problems.leetcode.findrightinterval;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    class Pair {
        int start;
        int end;
        int idx;
        int refIdx;

        public Pair(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }

        public String toString() {
            return "[" + this.start + ", " + this.end + "] idx: " + this.idx + " ref: " + this.refIdx;
        }
    }

    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        int [] ret = new int [len];
        Arrays.fill(ret, -1);
        Pair[] pairs = new Pair[len];

        for (int i=0;i<len;i++)
            pairs[i] = new Pair(intervals[i][0], intervals[i][1], i);

        Arrays.sort(pairs, new Comparator<Pair>(){
            public int compare(Pair a, Pair b) {
                return a.start - b.start;
            }
        });

        for (int i=0;i<len-1;i++)
            for (int j=i;j<len-1;j++)
                if (pairs[i].end <= pairs[j+1].start) {
                    pairs[i].refIdx = pairs[j+1].idx;
                    ret[pairs[i].idx] = pairs[i].refIdx;
                    break;
                }

        return ret;
    }
}