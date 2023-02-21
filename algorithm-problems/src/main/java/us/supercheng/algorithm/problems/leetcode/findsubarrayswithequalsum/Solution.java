package us.supercheng.algorithm.problems.leetcode.findsubarrayswithequalsum;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 1, len = nums.length; i < len; i++)
            if (!set.add(nums[i - 1] + nums[i]))
                return true;

        return false;
    }

}
