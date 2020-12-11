package us.supercheng.algorithm.problems.leetcode.uniquenumberofoccurrences;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        Integer[] map = new Integer[2001];
        Set<Integer> set = new HashSet<>();

        for (int n : arr) {
            int val = n + 1000;
            if (map[val] == null)
                map[val] = 0;
            map[val]++;
        }

        for (int i=0;i<2001;i++)
            if (map[i] != null) {
                if (set.contains(map[i]))
                    return false;
                set.add(map[i]);
            }
        return true;
    }
}