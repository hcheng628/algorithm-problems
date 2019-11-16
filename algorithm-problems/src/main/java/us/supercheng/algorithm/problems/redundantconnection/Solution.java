package us.supercheng.algorithm.problems.redundantconnection;

import java.util.*;

class Solution {

    public int[] findRedundantConnectionDFS(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int[] e : edges) {
            if (!graph.containsKey(e[0]))
                graph.put(e[0], new ArrayList<>());
            if (!graph.containsKey(e[1]))
                graph.put(e[1], new ArrayList<>());
        }

        for (int[] e : edges) {
            visited.clear();
            if (!graph.get(e[0]).isEmpty() && !graph.get(e[1]).isEmpty() && this.dfs(graph, e[0], e[1], visited))
                return e;
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);

        }
        return null;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int from, int to, Set<Integer> visited) {
        if (from == to)
            return true;

        if (visited.contains(from))
            return false;

        visited.add(from);
        for (int newFrom : graph.get(from))
            if (this.dfs(graph, newFrom, to, visited))
                return true;
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] ret = new int[2];
        int max = -1;

        for (int[] e : edges) {
            int from = e[0],
                    to = e[1];

            max = Math.max(max, Math.max(from, to));
            if (!graph.containsKey(from)) {
                List<Integer> list = new ArrayList<>();
                list.add(to);
                graph.put(from, list);
            } else
                graph.get(from).add(to);

            if (!graph.containsKey(to)) {
                List<Integer> list = new ArrayList<>();
                list.add(from);
                graph.put(to, list);
            } else
                graph.get(to).add(from);
        }

        for (int i=edges.length-1;i>-1;i--) {
            boolean[] visited = new boolean[max+1];
            if (i == edges.length-1)
                this.visit(graph, edges[i][0], edges[i][1], edges[i-1][0], visited);
            else
                this.visit(graph, edges[i][0], edges[i][1], edges[i+1][0], visited);

            boolean flag = true;
            for (int j=1;flag&&j<visited.length;j++)
                if (!visited[j])
                    flag = false;
            if (flag) {
                ret = new int[]{edges[i][0], edges[i][1]};
                break;
            }
        }

        return ret;
    }

    private void visit(Map<Integer, List<Integer>> graph, int from, int to, int next, boolean[] visited) {
        if (visited[next])
            return;

        visited[next] = true;

        for (int n : graph.get(next)) {
            if ((n == from && next == to) || (n == to && next == from))
                continue;
            this.visit(graph, from, to, n, visited);
        }
    }
}