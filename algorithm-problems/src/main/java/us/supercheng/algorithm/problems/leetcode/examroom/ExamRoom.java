package us.supercheng.algorithm.problems.leetcode.examroom;

import java.util.Map;
import java.util.TreeMap;

public class ExamRoom {

    int last;
    Map<Integer, Boolean> map;

    public ExamRoom(int N) {
        this.last = N - 1;
        this.map = new TreeMap<>();
    }

    public int seat() {
        if (map.isEmpty()) {
            map.put(0, true);
            return 0;
        }

        int ret = -1,
            d = Integer.MIN_VALUE,
            curr = -1,
            prev = -1,
            idx = 0,
            size = this.map.size();

        for (int key : this.map.keySet()) {
            if (idx == 0 && key  != 0) {
                d = key;
                ret = 0;
            }

            curr = key;
            if (prev > -1 && curr > -1) {
                int tempIdx = prev + (curr - prev)/2,
                        res = Math.min(tempIdx - prev, curr - tempIdx);
                if (res > d) {
                    d = res;
                    ret = tempIdx;
                }
            }

            if (idx == size - 1 && key != this.last && last - key > d) {
                d = last - key;
                ret = last;
            }

            prev = curr;
            idx++;
        }

        this.map.put(ret, true);
        return ret;
    }

    public void leave(int p) {
        this.map.remove(p);
    }
}