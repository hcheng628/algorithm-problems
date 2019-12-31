package us.supercheng.algorithm.problems.networkdelaytime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    Map<Integer, Map<Integer, Integer>> graph;
    Integer[] visited;

    public int networkDelayTime(int[][] times, int N, int K) {
        this.graph = new HashMap<>();
        this.visited = new Integer[N+1];

        // build graph
        for (int[] time : times) {
            if (!this.graph.containsKey(time[0]))
                this.graph.put(time[0], new HashMap<>());
            this.graph.get(time[0]).put(time[1], time[2]);
        }

        // dfs
        int ret = 0;
        this.dfs(K, 0);
        for (int i=1;i<=N;i++)
            if (this.visited[i] == null)
                return -1;
            else
                ret = Math.max(ret, this.visited[i]);
        return ret;
    }

    private void dfs(int from, int curr) {
        this.visited[from] = this.visited[from] == null ? curr : Math.min(this.visited[from], curr);
        Map<Integer, Integer> map = this.graph.get(from);
        if (map != null) {
            for (Integer to : map.keySet())
                if (this.visited[to] == null || this.visited[to] > curr + map.get(to))
                    this.dfs(to, curr+map.get(to));
        }
    }
}