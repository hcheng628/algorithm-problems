package us.supercheng.algorithm.problems.networkdelaytime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    Map<Integer, List<Node>> graph;
    Integer[] visited;

    public int networkDelayTime(int[][] times, int N, int K) {
        this.graph = new HashMap<>();
        this.visited = new Integer[N+1];

        // build graph
        for (int i=1;i<=N;i++)
            this.graph.put(i, new ArrayList<>());
        for (int[] time : times)
            this.graph.get(time[0]).add(new Node(time[1], time[2]));

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
        for (Node n : this.graph.get(from))
            if (this.visited[n.to] == null || this.visited[n.to] > curr + n.weight)
                this.dfs(n.to, curr + n.weight);
    }

    class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}