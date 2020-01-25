package us.supercheng.algorithm.problems.cheapestflightswithinkstops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // common
    Integer retVal;
    boolean[] visited;

    Map<Integer, List<int[]>> g;

    public int findCheapestPriceDFSArr(int n, int[][] flights, int src, int dst, int K) {
        this.g = new HashMap<>();
        this.visited = new boolean[n];

        for (int i=0, len=flights.length;i<len;i++) {
            if (!this.g.containsKey(flights[i][0]))
                this.g.put(flights[i][0], new ArrayList<>());
            this.g.get(flights[i][0]).add(new int[] {flights[i][1], flights[i][2]});
        }

        this.visited[src] = true;
        this.dfsArr(src, dst, K+1, 0);
        return this.retVal == null ? -1 : this.retVal;
    }

    private void dfsArr(int src, int dst, int stops, int cost) {
        if (src == dst) {
            this.retVal = cost;
            return;
        }
        if (stops == 0)
            return;

        List<int[]> trips = this.g.get(src);
        if (trips != null)
            for (int[] t : trips) {
                int next = t[0],
                        nextCost = t[1];
                if (this.visited[next] || (this.retVal != null && cost + nextCost >= this.retVal))
                    continue;
                this.visited[next] = true;
                this.dfsArr(next, dst, stops-1, cost + nextCost);
                this.visited[next] = false;
            }
    }

    Map<Integer, Map<Integer, Integer>> map;

    public int findCheapestPriceMap(int n, int[][] flights, int src, int dst, int K) {
        this.map = new HashMap<>();
        this.visited = new boolean[n];

        for (int[] f : flights)
            if (this.map.containsKey(f[0])) {
                Map<Integer, Integer> innerMap = map.get(f[0]);
                if (innerMap.get(f[1]) == null)
                    innerMap.put(f[1], f[2]);
                else {
                    int cost = innerMap.get(f[1]);
                    innerMap.put(f[1], Math.min(cost, f[2]));
                }
            } else {
                Map<Integer, Integer> innerMap = new HashMap<>();
                innerMap.put(f[1], f[2]);
                this.map.put(f[0], innerMap);
            }

        this.visited[src] = true;
        this.dfsMap(src, dst, K+1, flights, 0);
        return this.retVal == null ? -1 : this.retVal;
    }

    private void dfsMap(int src, int dst, int stops, int[][] F, int cost) {
        if (src == dst)
            this.retVal = cost;

        if (stops == 0)
            return;

        if (this.map.get(src) != null)
            for (int next : this.map.get(src).keySet()) {
                int tripCost = this.map.get(src).get(next);
                if (this.visited[next] || (this.retVal != null && cost+tripCost > this.retVal))
                    continue;

                this.visited[next] = true;
                this.dfsMap(next, dst, stops-1, F, cost+tripCost);
                this.visited[next] = false;
            }
    }

    private void printGraph() {
        for (int from : this.g.keySet()) {
            List<int[]> list = this.g.get(from);
            System.out.println("from: " + from);
            for (int[] row : list) {
                System.out.print("[" + row[0] + "," +row[1] + "],");
            }
            System.out.println("***********");
        }
    }
}