package us.supercheng.algorithm.problems.leetcode.contiguousarray;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;

        int ret = 0,
                sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i=0;i<nums.length;i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(sum))
                ret = Math.max(i-map.get(sum), ret);
            else
                map.put(sum, i);
        }

        return ret;
    }
}