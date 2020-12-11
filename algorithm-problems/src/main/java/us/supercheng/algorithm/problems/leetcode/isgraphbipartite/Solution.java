package us.supercheng.algorithm.problems.leetcode.isgraphbipartite;

public class Solution {

    public boolean isBipartite(int[][] graph) {
        for (int i=0,len=graph.length;i<len;i++)
            if (graph[i].length > 0 && !this.dfs(i, 1, graph, new int[len]))
                return false;
        return true;
    }

    private boolean dfs(int curr, int color, int[][] g, int[] visited) {
        if (visited[curr] != 0)
            return visited[curr] == color;

        visited[curr] = color;
        for (int next : g[curr])
            if (!this.dfs(next, -color, g, visited))
                return false;
        return true;
    }
}