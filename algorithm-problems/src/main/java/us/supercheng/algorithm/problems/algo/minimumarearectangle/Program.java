package us.supercheng.algorithm.problems.algo.minimumarearectangle;

import java.util.*;

public class Program {

    // Time: O(n^4) Space: O(1)
    public int minimumAreaRectangle(int[][] points) {
        int ret = 0;

        for (int i=0, len=points.length; i<len; i++)
            for (int j=i+1; j<len; j++)
                for (int k=j+1; k<len; k++)
                    for (int l=k+1; l<len; l++)
                        if (this.isParallel(points[i], points[j], points[k], points[l])) {
                            int res = this.calArea(points[i], points[j], points[k], points[l]);
                            if (ret == 0 || res < ret)
                                ret = res;
                        }

        return ret;
    }

    private int calArea(int[] a, int[] b, int[] c, int[] d) {
        int top = getMax(a[1], b[1], c[1], d[1]);
        int bot = getMin(a[1], b[1], c[1], d[1]);
        int left = getMin(a[0], b[0], c[0], d[0]);
        int right = getMax(a[0], b[0], c[0], d[0]);
        return (top - bot) * (right - left);
    }

    private boolean isParallel(int[] a, int[] b, int[] c, int[] d) {
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();

        int left = getMin(a[0], b[0], c[0], d[0]);
        int right = getMax(a[0], b[0], c[0], d[0]);

        int top = getMax(a[1], b[1], c[1], d[1]);
        int bot = getMin(a[1], b[1], c[1], d[1]);

        xMap.put(left, 0);
        xMap.put(right, 0);
        yMap.put(top, 0);
        yMap.put(bot, 0);

        for (int[] t : new int[][]{a, b, c, d}) {
            xMap.put(t[0], xMap.getOrDefault(t[0], 0) + 1);
            yMap.put(t[1], yMap.getOrDefault(t[1], 0) + 1);
        }

        return  xMap.get(left) == 2 && xMap.get(right) == 2 &&
                yMap.get(top) == 2 && yMap.get(bot) == 2;
    }

    private int getMax(int a, int b, int c, int d) {
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }

    private int getMin(int a, int b, int c, int d) {
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }

    // Time: O(n^2) Space: O(n)
    public int minimumAreaRectangle_Solution2(int[][] points) {
        int ret = 0;
        Map<Integer, Set<Integer>> xMap = new HashMap<>();

        for (int[] p : points) {
            int x = p[0];
            if (!xMap.containsKey(x))
                xMap.put(x, new HashSet<>());
            xMap.get(x).add(p[1]);
        }

        for (int i=0, len=points.length; i<len; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j=i+1; j<len; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (x1 != x2 && y1 != y2 && xMap.get(x1).contains(y2) && xMap.get(x2).contains(y1)) {
                    int res = Math.abs(x1 - x2) * Math.abs(y1 - y2);
                    if (ret == 0 || res < ret)
                        ret = res;
                }
            }
        }

        return ret;
    }
}
