package us.supercheng.algorithm.problems.leetcode.loudandrich;

import java.util.*;

public class Solution {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int len = quiet.length;
        int[] ret = new int[len];
        List<Set<Integer>> graph = new ArrayList<>();

        for (int i=0; i<len; i++) {
            graph.add(new HashSet());
            ret[i] = -1;
        }

        for (int[] row : richer)
            graph.get(row[1]).add(row[0]);

        for (int i=0; i<len; i++)
            this.dfs(graph, i, quiet, ret);

        return ret;
    }


    private void dfs(List<Set<Integer>> graph, int curr, int[] q, int[] result) {
        if (result[curr] != -1)
            return;

        result[curr] = curr;
        int val = q[curr];

        for (int next : graph.get(curr)) {
            this.dfs(graph, next, q, result);
            if (q[result[next]] < val) {
                val = q[result[next]];
                result[curr] = result[next];
            }
        }

    }
}