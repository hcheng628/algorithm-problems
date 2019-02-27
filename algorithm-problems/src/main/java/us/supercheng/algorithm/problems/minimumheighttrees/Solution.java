package us.supercheng.algorithm.problems.minimumheighttrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ret = new ArrayList<>();
        List<Integer> [] graph = new List[n];
        int [] degree = new int[n];

        for (int i=0;i<n;i++)
            graph[i] = new ArrayList<>();

        for (int i=0;i<edges.length;i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i=0;i<degree.length;i++) {
            if(degree[i] == 1)
                queue.add(i);
            else if(degree[i] == 0) {
                ret.add(0);
                return ret;
            }
        }


        while (!queue.isEmpty()) {
            ret = new ArrayList<>();
            int count = queue.size();
            for (int i=0;i<count;i++) {
                int curr = queue.poll();
                degree[curr]--;
                ret.add(curr);
                for (int j=0;j<graph[curr].size();j++)
                    if (--degree[graph[curr].get(j)] == 1)
                        queue.add(graph[curr].get(j));
            }
        }
        return ret;
    }
}