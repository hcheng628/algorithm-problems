package us.supercheng.algorithm.problems.leetcode.binarytreeswithfactors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        Map<Integer, Long> map = new HashMap<>();
        long ret = 0;
        int len = A.length,
            MOD = 1000000007;

        for (int i=0;i<len;i++) {
            int root = A[i];
            long amt = 1;

            for (int j=0;j<i;j++) {
                int left = A[j],
                        right = root / left;
                if (root % left == 0 && map.containsKey(right))
                    amt +=  map.get(left) * map.get(right) % MOD;
            }
            map.put(root, amt);
        }

        for (Long n : map.values())
            ret = (ret + n % MOD) % MOD;

        return (int) ret;
    }
}