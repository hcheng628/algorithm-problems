package us.supercheng.algorithm.problems.allpathsfromsourcetotarget;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        this.dfs(graph, ret, 0, graph.length-1, list);

        return ret;
    }

    private void dfs(int[][] graph, List<List<Integer>> ret, int curr, int to, List<Integer> list) {
        if (curr == to) {
            ret.add(new ArrayList<>(list));
            return;
        }

        for (int next : graph[curr]) {
            list.add(next);
            this.dfs(graph, ret, next, to, list);
            list.remove(list.size()-1);
        }
    }
}