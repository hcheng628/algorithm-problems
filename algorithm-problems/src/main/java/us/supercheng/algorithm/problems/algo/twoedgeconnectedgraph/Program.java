package us.supercheng.algorithm.problems.algo.twoedgeconnectedgraph;

import java.util.*;

public class Program {

    // Time: O(v*e) Space: O(e)
    public boolean twoEdgeConnectedGraph(int[][] edges) {
        if (edges == null || edges.length < 2)
            return true;

        int len = edges.length;

        if (this.travel(edges, new HashSet<>(), 0).size() != len)
            return false;

        for (int[] row : edges)
            for (int i=0, colLen=row.length; i<colLen; i++) {
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

}
