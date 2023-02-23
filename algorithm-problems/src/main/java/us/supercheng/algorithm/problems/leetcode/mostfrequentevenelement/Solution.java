package us.supercheng.algorithm.problems.leetcode.mostfrequentevenelement;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int mostFrequentEven(int[] nums) {
        int[] info = new int[]{-1, 0};
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums)
            if (n % 2 == 0) {
                map.put(n, map.getOrDefault(n, 0) + 1);
                if (info[1] < map.get(n) || (info[1] == map.get(n) && n < info[0]))
                    info = new int[]{n, map.get(n)};
            }

        return info[0];
    }

}
