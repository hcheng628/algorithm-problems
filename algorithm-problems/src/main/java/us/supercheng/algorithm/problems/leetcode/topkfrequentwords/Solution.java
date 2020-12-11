package us.supercheng.algorithm.problems.leetcode.topkfrequentwords;

import java.util.*;

import java.util.Arrays;

class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length,
                target = 0,
                idx = 0;

        for (int n : nums)
            target += n;

        if (target % k != 0)
            return false;

        target /= k;
        Arrays.sort(nums);
        idx = Arrays.binarySearch(nums, target+1);
        if (idx >-1 || idx >= -len)
            return false;

        for (idx = len-1;nums[idx]==target;) {
            k--;
            idx--;
        }
        return this.dfs(new int[k], nums, idx, target);
    }

    private boolean dfs(int[] set, int[] nums, int idx, int target) {
        if (idx < 0)
            return true;

        int curr = nums[idx];
        for (int i=0;i<set.length;i++) {
            if (set[i] + curr <= target) {
                set[i] += curr;
                if (this.dfs(set, nums, idx-1, target))
                    return true;
                set[i] -= curr;
            }

            if (set[i] == 0)
                break;
        }
        return false;
    }
}