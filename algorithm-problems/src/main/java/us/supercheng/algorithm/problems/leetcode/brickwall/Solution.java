package us.supercheng.algorithm.problems.leetcode.brickwall;

import java.util.*;

class Solution {

    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null)
            return 0;

        int height = wall.size(),
                max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<height;i++) {
            int end = wall.get(i).size()-1;
            for (int j=0, dis=0;j<end;j++) {
                int val = wall.get(i).get(j),
                        key = val + dis;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(map.get(key), max);
                dis += val;
            }
        }

        return height - max;
    }
}