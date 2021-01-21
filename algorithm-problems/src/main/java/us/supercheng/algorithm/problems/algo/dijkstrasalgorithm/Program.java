package us.supercheng.algorithm.problems.algo.dijkstrasalgorithm;

import java.util.*;

public class Program {

    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        int len = edges.length;
        Set<Integer> visited = new HashSet<>();
        int[] ret = new int[len];
        Arrays.fill(ret, -1);
        ret[start] = 0;

        while (true) {
            int idx = this.nextNode(ret, visited, edges);
            if (idx == -1 || ret[idx] == -1)
                break;

            visited.add(idx);
            for (int[] e : edges[idx]) {
                int next = e[0];
                int dis = e[1];
                if (ret[next] == -1 || dis + ret[idx] < ret[next])
                    ret[next] = dis + ret[idx];
            }
        }

        return ret;
    }

    private int nextNode(int[] ret, Set<Integer> visited, int[][][] edges) {
        int idx = -1;

        for (int i=0, dis = Integer.MAX_VALUE, len=edges.length; i<len; i++)
            if (ret[i] != -1 && !visited.contains(i) && (idx == -1 || ret[i] < dis)) {
                idx = i;
                dis = ret[i];
            }

        return idx;
    }

}