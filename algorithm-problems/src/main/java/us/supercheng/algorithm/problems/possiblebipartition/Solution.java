package us.supercheng.algorithm.problems.possiblebipartition;

import java.util.*;

public class Solution {

    private Map<Integer, Set<Integer>> map;
    private Boolean[] visited;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        this.map = new HashMap<>();
        this.visited = new Boolean[N+1];

        for (int[] d : dislikes) {
            this.initMap(d[0], d[1]);
            this.initMap(d[1], d[0]);
        }

        for (Integer curr : map.keySet())
            if (this.visited[curr] == null && !this.dfs(curr, true))
                return false;

        return true;
    }

    private boolean dfs(int curr, boolean trueT) {
        if (this.visited[curr] == null)
            this.visited[curr] = trueT;

        for (Integer h : this.map.get(curr))
            if (this.visited[h] ==  null) {
                this.visited[h] = !trueT;
                if (!this.dfs(h, !trueT)) {
                    return false;
                }
            } else if (trueT == this.visited[h])
                return false;

        return true;
    }

    private void initMap(int a, int b) {
        if (!map.containsKey(a)) {
            Set<Integer> set = new HashSet<>();
            map.put(a, set);
            set.add(b);
        } else {
            Set<Integer> set = map.get(a);
            if (!set.contains(b))
                set.add(b);
        }
    }

    // BFS + DFS

    private List<List<Integer>> graph;

    public boolean possibleBipartitionBFS(int N, int[][] dislikes) {
        this.graph = new ArrayList<>();
        this.visited = new Boolean[N+1];
        this.initGraph(N, dislikes);

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            List<Integer> l = this.graph.get(i);
            if (this.visited[i] == null && l.size() > 0) {
                q.add(i);
                this.visited[i] = true;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (Integer h : this.graph.get(curr)) {
                        if (this.visited[h] == null) {
                            this.visited[h] = !this.visited[curr];
                            q.add(h);
                        } else if (this.visited[h] == this.visited[curr])
                            return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean possibleBipartitionDFS(int N, int[][] dislikes) {
        this.graph = new ArrayList<>();
        this.visited = new Boolean[N+1];
        this.initGraph(N, dislikes);

        for (int i=1; i<=N; i++)
            if (this.visited[i] == null && this.graph.get(i).size() > 0 && !this.dfsGraph(i, true))
                return false;

        return true;
    }

    private boolean dfsGraph(int curr, boolean trueT) {
        if (this.visited[curr] == null)
            this.visited[curr] = trueT;

        for (Integer h : this.graph.get(curr))
            if (this.visited[h] ==  null) {
                if (!this.dfsGraph(h, !trueT))
                    return false;
            } else if (trueT == this.visited[h])
                return false;

        return true;
    }

    private void initGraph(int N, int[][] dislikes) {
        for (int i=0; i<=N; i++)
            this.graph.add(new ArrayList<>());

        for (int[] d : dislikes) {
            List<Integer> l = this.graph.get(d[0]);
            l.add(d[1]);
            l = this.graph.get(d[1]);
            l.add(d[0]);
        }
    }
}