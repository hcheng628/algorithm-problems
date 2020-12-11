package us.supercheng.algorithm.problems.leetcode.increasingtripletsubsequence;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        Integer min = null, mid = null;
        for (int each : nums)
            if (min == null || each <= min)
                min = each;
            else if (mid == null || each <= mid)
                mid = each;
            else
                return true;
        return false;
    }
}