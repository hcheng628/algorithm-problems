package us.supercheng.algorithm.problems.leetcode.numberofequivalentdominopairs;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int numEquivDominoPairs(int[][] dominoes) {
        int ret = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int[] row : dominoes) {
            String s = null;
            if (row[0] > row[1])
                s = row[1] + "," + row[0];
            else
                s = row[0] + "," + row[1];
            map.put(s, map.getOrDefault(s, 0)+1);
        }

        for (String key : map.keySet()) {
            int val = map.get(key);
            if (val-- > 1)
                ret += (val+1)*val/2;
        }

        return ret;
    }

    public int numEquivDominoPairs2(int[][] dominoes) {
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] dom : dominoes) {
            int res = Math.max(dom[0], dom[1]) + Math.min(dom[0], dom[1]) * 10,
                occurs = map.getOrDefault(res, 0);
            ret += occurs;
            map.put(res, occurs+1);
        }

        return ret;
    }
}