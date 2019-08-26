package us.supercheng.algorithm.problems.numberofequivalentdominopairs;

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
}