package us.supercheng.algorithm.problems.subarraysumequalsk;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int subarraySum(int[] nums, int k) {
        int len = nums.length,
                count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i=0, sum=0;i<len;i++) {
            sum += nums[i];
            int key = sum-k;
            if (map.containsKey(key))
                count += map.get(key);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return count;
    }
}