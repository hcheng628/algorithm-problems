package us.supercheng.algorithm.problems.leetcode.findthedifferenceoftwoarrays;

import java.util.*;

class Solution {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ret = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (Integer n : nums1)
            set1.add(n);
        for (Integer n : nums2)
            set2.add(n);

        for (Integer n : set1)
            if (!set2.contains(n))
                ret.get(0).add(n);

        for (Integer n : set2)
            if (!set1.contains(n))
                ret.get(1).add(n);

        return ret;
    }

}
