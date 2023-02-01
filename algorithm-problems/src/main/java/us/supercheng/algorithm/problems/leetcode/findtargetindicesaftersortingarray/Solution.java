package us.supercheng.algorithm.problems.leetcode.findtargetindicesaftersortingarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> targetIndicesBS(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> ret = new ArrayList<>();

        int idx = Arrays.binarySearch(nums, target);
        if (idx < 0)
            return ret;

        for (int i = idx - 1; i > - 1 && nums[i] == target; i--)
            ret.add(0, i);

        for (int i = idx, len = nums.length; i < len && nums[i] == target; i++)
            ret.add(i);

        return ret;
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        int lessCount = 0;
        int equalCount = 0;
        List<Integer> ret = new ArrayList<>();

        for (int n : nums) {
            if (n == target)
                equalCount++;
            else if (n < target)
                lessCount++;
        }

        for (int i = 0; i < equalCount; i++)
            ret.add(lessCount + i);

        return ret;
    }

}
