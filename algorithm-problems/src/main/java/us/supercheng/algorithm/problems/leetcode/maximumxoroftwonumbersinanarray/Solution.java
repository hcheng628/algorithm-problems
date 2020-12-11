package us.supercheng.algorithm.problems.leetcode.maximumxoroftwonumbersinanarray;

import java.util.HashSet;

class Solution {

    public int findMaximumXOR(int[] nums) {
        int ret = 0;
        for (int i=31;i>-1;i--) {
            int curr = ret | (1 << i);
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums)
                set.add(num & curr);
            for (int val : set)
                if (set.contains(val ^ curr)) {
                    ret = curr;
                    break;
                }
        }
        return ret;
    }

}