package us.supercheng.algorithm.problems.leetcode.targetsum;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private Map<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0)
            return S == 0 ? 1 : 0;
        this.memo = new HashMap<>();
        return this.doFind(nums, 0, 0, S, 0, "");
    }

    private int doFind(int[] nums, int idx, int curr, int S, int count, String s) {
        if (idx == nums.length)
            return curr == S ? 1 : 0;

        String key = idx + "->" + curr;
        Integer retVal = this.memo.get(key);
        if (retVal != null)
            return retVal;

        retVal = this.doFind(nums, idx+1, curr + nums[idx], S, count, s + "+") +
                this.doFind(nums, idx+1, curr - nums[idx], S, count, s + "-");
        this.memo.put(key, retVal);
        return retVal;
    }
}