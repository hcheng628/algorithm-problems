package us.supercheng.algorithm.problems.rabbitsinforest;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret = 0;

        for (int a : answers)
            if (map.containsKey(a) && map.get(a) > 0)
                map.put(a, map.get(a)-1);
            else {
                map.put(a, a);
                ret += a+1;
            }

        return ret;
    }
}
