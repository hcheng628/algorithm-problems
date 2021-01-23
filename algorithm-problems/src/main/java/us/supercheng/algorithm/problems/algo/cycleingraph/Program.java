package us.supercheng.algorithm.problems.algo.cycleingraph;

import java.util.*;

public class Program {

    // Time: O(n^2) Space: O(n^2)
    public boolean cycleInGraph(int[][] edges) {
        for (int i=0, len=edges.length; i<len; i++)
            if (this.travel(new HashSet<>(), edges, i))
                return true;
        return false;
    }

    private boolean travel(Set<Integer> visited, int[][] g, int from) {
        if (visited.contains(from))
            return true;

        visited.add(from);
        for (int to : g[from]) {
            if (this.travel(visited, g, to))
                return true;
            visited.remove(to);
        }
        return false;
    }
}
