package us.supercheng.algorithm.problems.leetcode.longestharmonioussubsequence;

import java.util.HashMap;

public class App {

    public int findLHS(int[] nums) {
        int count = 0;
        if(nums == null || nums.length < 2)
            return count;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int each : nums)
            map.put(each, map.getOrDefault(each, 0) + 1);

        for(int key : map.keySet())
            if(map.containsKey(key + 1))
                count = Math.max(count, map.get(key) + map.get(key + 1));
        return count;
    }
}