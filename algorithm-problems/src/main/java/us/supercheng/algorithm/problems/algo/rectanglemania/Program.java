package us.supercheng.algorithm.problems.algo.rectanglemania;

import java.util.*;

public class Program {

    // Time: O(n^2) Space: O(n)
    public static int rectangleMania_Solution1(Point[] coords) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int ret = 0;

        for (Point p : coords) {
            int x = p.x;
            if (!map.containsKey(x))
                map.put(x, new HashSet<>());
            map.get(x).add(p.y);
        }

        Arrays.sort(coords, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x != o2.x ? o1.x - o2.x : o1.y - o2.y;
            }
        });

        for (Point p : coords)
            ret += helper(map, p.x, p.y);

        return ret;
    }

    private static int helper(Map<Integer, Set<Integer>> map, int x, int y) {
        int ret = 0;

        for (int newY : map.get(x))
            for (int newX=-100; newY < y && newX<x; newX++) {
                Set<Integer> set = map.get(newX);
                if (set != null && set.contains(y) && set.contains(newY))
                    ret++;
            }

        return ret;
    }

    // Time: O(n^2) Space: O(n)
    public static int rectangleMania(Point[] coords) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int ret = 0;

        for (Point p : coords) {
            int x = p.x;
            if (!map.containsKey(x))
                map.put(x, new HashSet<>());
            map.get(x).add(p.y);
        }

        for (Point p : coords) {
            int x1 = p.x;
            int y1 = p.y;
            for (Point p2 : coords) {
                int x2 = p2.x;
                int y2 = p2.y;
                if (x2 > x1 && y2 < y1 && map.get(x1).contains(y2) && map.get(x2).contains(y1))
                    ret++;
            }
        }

        return ret;
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}