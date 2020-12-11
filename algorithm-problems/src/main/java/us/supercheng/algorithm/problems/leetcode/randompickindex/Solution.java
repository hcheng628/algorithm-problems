package us.supercheng.algorithm.problems.leetcode.randompickindex;

import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> map;
    private Random rand;

    public Solution(int[] nums) {
        this.map = new HashMap<>();
        this.rand = new Random();

        for (int i=0;i<nums.length;i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

    }

    public int pick(int target) {
        List<Integer> list = this.map.get(target);
        return list.get(this.rand.nextInt(list.size()));
    }
}