package us.supercheng.algorithm.problems.leetcode.findallkdistantindicesinanarray;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ret = new ArrayList<>();
        int last = 0;

        for (int i = 0, len = nums.length; i < len; i++)
            if (nums[i] == key) {
                int right = Math.min(i + k, nums.length - 1);
                for (int idx = Math.max(i - k, last); idx <= right; idx++)
                    ret.add(idx);
                last = right + 1;
            }

        return ret;
    }

}