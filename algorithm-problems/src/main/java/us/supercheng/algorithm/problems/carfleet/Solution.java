package us.supercheng.algorithm.problems.carfleet;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public int carFleet(int target, int[] position, int[] speed) {
        if (target < 1 || position == null || speed == null)
            return 0;

        Map<Integer, Double> map = new TreeMap<>(Collections.reverseOrder());

        for (int i=0, len = position.length; i<len; i++)
            map.put(position[i], (target - position[i]) * 1.0 /speed[i]);

        int ret = 0;
        double currT = 0.0;

        for (double t : map.values())
            if (t > currT) {
                currT = t;
                ret++;
            }

        return ret;
    }
}