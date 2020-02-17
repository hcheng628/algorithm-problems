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

    public List<Integer> eventualSafeNodesOPT(int[][] graph) {
        int len = graph.length;
        Boolean[] res = new Boolean[len];
        boolean[] visited = new boolean[len];
        List<Integer> ret = new ArrayList<>();

        for (int from=0;from<len;from++)
            if (this.dfsOPT(graph, from, visited, res, ret))
                ret.add(from);

        return ret;
    }

    private boolean dfsOPT(int[][] graph, int curr, boolean[] visited, Boolean[] res, List<Integer> ret) {
        if (res[curr] != null)
            return res[curr];

        if (visited[curr])
            return false;

        visited[curr] = true;
        for (int next : graph[curr])
            if (!this.dfsOPT(graph, next, visited, res, ret))
                return res[next] = false;

        return res[curr] = true;
    }
}