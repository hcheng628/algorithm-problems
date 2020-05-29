package us.supercheng.algorithm.problems.advantageshuffle;

import java.util.TreeMap;

public class Solution {

    public int[] advantageCount(int[] A, int[] B) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int a : A)
            map.put(a, map.getOrDefault(a, 0) + 1);

        for (int i=0, len=A.length; i<len; i++) {
            Integer res = map.ceilingKey(B[i]+1);

            if (res == null) {
                res = map.ceilingKey(-1);
            }

            A[i] = res;

            if (map.get(res) == 1)
                map.remove(res);
            else
                map.put(res, map.get(res)-1);
        }

        return A;
    }
}