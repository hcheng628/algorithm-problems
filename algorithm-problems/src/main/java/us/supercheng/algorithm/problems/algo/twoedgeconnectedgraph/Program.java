package us.supercheng.algorithm.problems.algo.twoedgeconnectedgraph;

import java.util.*;

public class Program {

    // Time: O(v*(e+v)) Space: O(v)
    public boolean twoEdgeConnectedGraph_Solution1(int[][] edges) {
        if (edges == null || edges.length < 2)
            return true;

        int len = edges.length;

        if (this.travel(edges, new HashSet<>(), 0).size() != len)
            return false;

        for (int[] row : edges)
            for (int i = 0, colLen = row.length; i < colLen; i++) {
                int backup = row[i];
                row[i] = -1;
                if (this.travel(edges, new HashSet<>(), 0).size() != len)
                    return false;
                row[i] = backup;
            }

        return true;
    }

    private Set<Integer> travel(int[][] mat, Set<Integer> visited, int from) {
        if (!visited.contains(from)) {
            visited.add(from);
            for (int to : mat[from])
                if (to != -1)
                    this.travel(mat, visited, to);
        }

        return visited;
    }

    // Time: O(e+v) Space: O(v)
    public boolean twoEdgeConnectedGraph(int[][] edges) {
        if (edges == null || edges.length < 2)
            return true;

        Map<Integer, int[]> map = new HashMap<>();
        this.helper(edges, map, -1, 0, 1);
        return this.validateRes(map, edges.length);
    }

    private int helper(int[][] mat, Map<Integer, int[]> map, int from, int curr, int sequence) {
        int[] info = map.get(curr);
        if (info != null)
            return info[1];

        info = new int[]{sequence, sequence};
        map.put(curr, info);

        for (int to : mat[curr]) {
            if (to < 0 || to == from)
                continue;
            info[1] = Math.min(this.helper(mat, map, curr, to, sequence + 1), info[1]);
        }

        if (curr != 0 && info[0] == info[1])
            info[1] = -1;

        return info[1];
    }

    private boolean validateRes(Map<Integer, int[]> map, int size) {
        if (map.size() != size)
            return false;

        for (int[] info : map.values())
            if (info[1] == -1)
                return false;

        return true;
    }
}
