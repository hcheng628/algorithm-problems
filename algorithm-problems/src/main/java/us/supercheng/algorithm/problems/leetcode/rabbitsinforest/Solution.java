package us.supercheng.algorithm.problems.leetcode.rabbitsinforest;

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

    public int numRabbitsOPT(int[] answers) {
        int[] map = new int[1000];
        int ret = 0;

        for (int a : answers)
            if (map[a] > 0)
                map[a]--;
            else {
                map[a] = a;
                ret += a+1;
            }

        return ret;
    }
}
