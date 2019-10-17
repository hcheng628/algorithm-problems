package us.supercheng.algorithm.problems.splitarrayintoconsecutivesubsequences;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(),
                resMap = new HashMap<>();

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (int num : nums) {
            if (map.get(num) == 0)
                continue;

            if (resMap.containsKey(num-1) && resMap.get(num-1) > 0) {
                resMap.put(num-1, resMap.get(num-1) - 1);
                resMap.put(num, resMap.getOrDefault(num, 0) + 1);
            } else if (map.containsKey(num+1) && map.get(num+1) > 0 && map.containsKey(num+2) && map.get(num+2) > 0) {
                resMap.put(num+2, resMap.getOrDefault(num+2, 0) + 1);
                map.put(num+1, map.get(num+1) -1);
                map.put(num+2, map.get(num+2) -1);
            } else
                return false;
            map.put(num, map.get(num) -1);
        }

        return true;
    }
}