package us.supercheng.algorithm.problems.leetcode.twooutofthree;

import java.util.*;

public class Solution {

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ret = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        this.updateMap(nums1, map, 1);
        this.updateMap(nums2, map, 2);
        this.updateMap(nums3, map, 3);

        for (Map.Entry<Integer, Set<Integer>> e : map.entrySet())
            if (e.getValue().size() > 1)
                ret.add(e.getKey());

        return ret;
    }

    private void updateMap(int[] nums, Map<Integer, Set<Integer>> map, int tag) {
        for (int n : nums) {
            Set<Integer> set = map.get(n);
            if (set == null) {
                set = new HashSet<>();
                map.put(n, set);
            }
            set.add(tag);
        }
    }

    public List<Integer> twoOutOfThreeOPT(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ret = new ArrayList<>();
        int[][] counts = new int[3][101];

        for (int n : nums1)
            counts[0][n] = 1;
        for (int n : nums2)
            counts[1][n] = 1;
        for (int n : nums3)
            counts[2][n] = 1;

        for (int num = 1; num < 101; num++)
            if (counts[0][num] + counts[1][num] + counts[2][num] > 1)
                ret.add(num);

        return ret;
    }

}
