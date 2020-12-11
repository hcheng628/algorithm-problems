package us.supercheng.algorithm.problems.leetcode.evaluatedivision;

import java.util.*;

class Solution {

    class Point {
        String name;
        Double val;

        Point(String name, Double val) {
            this.name = name;
            this.val = val;
        }
    }

    Map<String, List<Point>> map;

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        this.map = new HashMap<>();
        double[] ret = new double [queries.length];

        for (int i=0;i<equations.length;i++) {
            if (!this.map.containsKey(equations[i][0]))
                this.map.put(equations[i][0], new ArrayList<>());
            if (!this.map.containsKey(equations[i][1]))
                this.map.put(equations[i][1], new ArrayList<>());
            this.map.get(equations[i][0]).add(new Point(equations[i][1], values[i]));
            this.map.get(equations[i][1]).add(new Point(equations[i][0], 1/values[i]));
        }

        for (int i=0;i<queries.length;i++) {
            Double res = this.doCal(queries[i][0], queries[i][1], new HashSet<>());
            ret[i] = res == null ? -1.0 : res;
        }

        return ret;
    }

    private Double doCal(String from, String to, Set<String> visited) {
        if (!map.containsKey(from) || !map.containsKey(to))
            return null;
        if (from.equals(to))
            return 1.0;

        visited.add(from);

        for (Point point : map.get(from))
            if (!visited.contains(point.name)) {
                Double res = this.doCal(point.name, to, visited);
                if (res != null)
                    return res * point.val;
            }

        visited.remove(from);

        return null;
    }

}