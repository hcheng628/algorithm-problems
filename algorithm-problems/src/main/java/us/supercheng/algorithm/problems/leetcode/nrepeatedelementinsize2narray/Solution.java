package us.supercheng.algorithm.problems.leetcode.nrepeatedelementinsize2narray;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap();
        for(int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
            if(map.get(a) == A.length / 2)
                return a;
        }
        return -1;
    }
}