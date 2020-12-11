package us.supercheng.algorithm.problems.leetcode.flowerplantingwithnoadjacent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] ret = new int [N];
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i=1;i<=N;i++)
            map.put(i, new HashSet<Integer>());

        for (int[] path : paths) {
            map.get(path[0]).add(path[1]);
            map.get(path[1]).add(path[0]);
        }

        for (Integer g : map.keySet()) {
            boolean[] colored = new boolean[5];
            for (Integer eachG : map.get(g)) {
                int idx = eachG-1;
                if (ret[idx] != 0)
                    colored[ret[idx]] = true;
            }

            for (int i=1;i<5;i++)
                if (!colored[i]) {
                    ret[g-1] = i;
                    break;
                }
        }
        return ret;
    }
}