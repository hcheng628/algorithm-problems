package us.supercheng.algorithm.problems.leetcode.foursumii;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int ret = 0;
        Map<Integer, Integer> resAB = new HashMap<>();
        for (int i=0;i<A.length;i++)
            for (int j=0;j<A.length;j++) {
                int res = A[i] + B[j];
                resAB.put(res, resAB.getOrDefault(res, 0) + 1);
            }

        for (int i=0;i<A.length;i++)
            for (int j=0;j<A.length;j++)
                if (resAB.containsKey(-C[i]-D[j]))
                    ret += resAB.get(-C[i]-D[j]);
        return ret;
    }
}