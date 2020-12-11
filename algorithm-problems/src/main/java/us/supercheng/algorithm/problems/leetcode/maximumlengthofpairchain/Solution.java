package us.supercheng.algorithm.problems.leetcode.maximumlengthofpairchain;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    Integer[] memo;

    public int findLongestChain(int[][] pairs) {
        int ret = 1;
        this.memo= new Integer[pairs.length];

        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
            }
        });

        for (int i=0;i<pairs.length;i++)
            ret = Math.max(ret, this.dfs(i, pairs));

        return ret;
    }

    private int dfs(int idx, int[][] pairs) {
        if (this.memo[idx] != null)
            return this.memo[idx];

        int ret = 0;
        for (int i=idx+1;i<pairs.length;i++)
            if (pairs[i][0] > pairs[idx][1])
                ret = Math.max(ret, this.dfs(i, pairs));

        this.memo[idx] = ret+1;
        return this.memo[idx];
    }
}