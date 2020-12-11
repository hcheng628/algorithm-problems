package us.supercheng.algorithm.problems.leetcode.minimumarearectangle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int ret = 0;

        for (int[] p : points) {
            Set<Integer> set = map.get(p[0]);
            if (set == null) {
                set = new HashSet<>();
                set.add(p[1]);
                map.put(p[0], set);
            } else
                set.add(p[1]);
        }

        for (int i=0, len = points.length; i<len; i++)
            for (int j=i+1; j<len; j++) {
                int[] a = points[i],
                        b = points[j];
                int res = Math.abs(a[0] - b[0]) * Math.abs(a[1] - b[1]);

                if (res !=0 && (res < ret || ret == 0) && map.containsKey(a[0]) && map.get(a[0]).contains(b[1]) &&
                        map.containsKey(b[0]) && map.get(b[0]).contains(a[1]))
                    ret = res;
            }

        return ret;
    }
}