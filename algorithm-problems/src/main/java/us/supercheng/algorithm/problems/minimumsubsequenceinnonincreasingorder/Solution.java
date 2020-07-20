package us.supercheng.algorithm.problems.minimumsubsequenceinnonincreasingorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int total = 0;
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(nums);

        for (int n : nums)
            total += n;

        for (int idx=nums.length-1, curr = 0; idx>-1; idx--) {
            ret.add(nums[idx]);
            total -= nums[idx];
            curr += nums[idx];
            if (curr > total)
                return ret;
        }

        return ret;
    }
}