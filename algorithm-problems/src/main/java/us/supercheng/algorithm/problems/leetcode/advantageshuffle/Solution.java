package us.supercheng.algorithm.problems.leetcode.advantageshuffle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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

    public int lenLongestFibSubseqDP(int[] A) {
        int len = A.length,
                ret = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[len][len];

        for (int i=0; i<len; i++) {
            Arrays.fill(dp[i], 2);
            map.put(A[i], i);
        }

        for (int i=0; i<len; i++)
            for (int j=i+1; j<len; j++) {
                int val = A[j] - A[i];
                if (val >= A[i])
                    break;

                Integer idx = map.get(val);
                if (idx == null)
                    continue;

                dp[i][j] = dp[idx][i] + 1;
                ret = Math.max(ret, dp[i][j]);
            }

        return ret > 2 ? ret : 0;
    }
}