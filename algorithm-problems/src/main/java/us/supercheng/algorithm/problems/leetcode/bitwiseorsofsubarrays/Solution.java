package us.supercheng.algorithm.problems.leetcode.bitwiseorsofsubarrays;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> set = new HashSet<>(),
                curr = new HashSet<>();

        for (int a : A) {
            Set<Integer> temp = new HashSet<>();

            temp.add(a);
            for (int c : curr)
                temp.add(c | a);

            for (int each : temp)
                set.add(each);

            curr = temp;
        }

        return set.size();
    }

    public int subarrayBitwiseORsDPTLE(int[] A) {
        int len = A.length;
        int[][] dp = new int[len][len];
        Set<Integer> set = new HashSet<>();

        // init
        for (int i=0; i<len; i++) {
            dp[i][0] = A[i];
            set.add(dp[i][0]);
        }

        for (int wid=1; wid<len; wid++)
            for (int idx=0; idx<len-wid; idx++) {
                dp[idx][wid] = dp[idx][wid-1] | A[idx+wid];
                set.add(dp[idx][wid]);
            }

        return set.size();
    }

}
