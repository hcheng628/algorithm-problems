package us.supercheng.algorithm.problems.findeventualsafestates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int len = graph.length;
        boolean[] set = new boolean[len];
        List<Integer> ret = new ArrayList<>();

        for (int from=0;from<len;from++)
            if (!set[from] && this.dfs(graph, from, new boolean[len], set, ret)) {
                set[from] = true;
                ret.add(from);
            }

        Collections.sort(ret);
        return ret;
    }

    private boolean dfs(int[][] graph, int curr, boolean[] visited, boolean[] set, List<Integer> ret) {
        if (visited[curr] || set[curr])
            return false;

        visited[curr] = true;
        for (int next : graph[curr])
            if (!set[next]) {
                if (!this.dfs(graph, next, visited, set, ret))
                    return false;
                visited[next] = false;
                set[next] = true;
                ret.add(next);
            }
        return true;
    }
}