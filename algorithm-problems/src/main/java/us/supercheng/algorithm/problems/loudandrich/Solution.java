package us.supercheng.algorithm.problems.loudandrich;

import java.util.*;

public class Solution {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, Set<Integer>> map = new HashMap();
        int len = quiet.length;
        int[] ret = new int[len];

        for (int i=0; i<len; i++)
            map.put(i, new HashSet<>());

        for (int[] row : richer)
            map.get(row[1]).add(row[0]);

        for (int i=0; i<len; i++) {
            Set<Integer> set = map.get(i);
            for (int each : new ArrayList<>(set))
                this.dfs(map, map.get(i), each);
        }

        for (int i=0; i<len; i++) {
            int val = quiet[i],
                idx = i;

            for (int each : map.get(i))
                if (quiet[each] < val) {
                    val = quiet[each];
                    idx = each;
                }

            ret[i] = idx;
        }

        return ret;
    }


    private void dfs(Map<Integer, Set<Integer>> map, Set<Integer> target, int curr) {
        for (int each : map.get(curr)) {
            if (target.contains(each))
                continue;
            target.add(each);
            this.dfs(map, target, each);
        }
    }
}
