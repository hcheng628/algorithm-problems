package us.supercheng.algorithm.problems.leetcode.findthedistinctdifferencearray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] distinctDifferenceArrayMap(int[] nums) {
        if (nums == null || nums.length < 1)
            return null;

        int len = nums.length;
        int[] ret = new int[len];
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        for (int i = 0; i < len; i++)
            rightMap.put(nums[i], rightMap.getOrDefault(nums[i], 0) + 1);

        for (int i = 0; i < len; i++) {
            int count = rightMap.get(nums[i]);
            if (count == 1)
                rightMap.remove(nums[i]);
            else
                rightMap.put(nums[i], count - 1);

            leftMap.put(nums[i], rightMap.getOrDefault(nums[i], 0) + 1);
            ret[i] = leftMap.size() - rightMap.size();
        }

        return ret;
    }

    public int[] distinctDifferenceArray(int[] nums) {
        if (nums == null || nums.length < 1)
            return null;

        int len = nums.length;
        int[] ret = new int[len];
        int[] leftMap = new int[51];
        int[] rightMap = new int[51];

        for (int num : nums) rightMap[num]++;

        for (int i = 0; i < len; i++) {
            leftMap[nums[i]]++;
            rightMap[nums[i]]--;
            ret[i] = count(leftMap) - count(rightMap);
        }

        return ret;
    }

    private int count(int[] arr) {
        return (int) Arrays.stream(arr).filter(a -> a != 0).count();
    }

}
