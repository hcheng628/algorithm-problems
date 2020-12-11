package us.supercheng.algorithm.problems.leetcode.containsduplicateiii;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.TreeSet;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 5, 9, 1, 5, 9};

        boolean res = solution.containsNearbyAlmostDuplicate(nums, 2, 3);
        PrintHelper.echoLn(res);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length < 2 || k < 1)
            return false;
        TreeSet<Long> treeSet = new TreeSet<>();

        for(int i=0;i<nums.length;i++) {
            Long min = treeSet.floor((long) nums[i]);
            Long max = treeSet.ceiling((long) nums[i]);
            if((min != null && nums[i] - min <= t) || (max != null && max - nums[i] <=t))
                return true;
            if(i>=k)
                treeSet.remove((long)nums[i-k]);
            treeSet.add((long)nums[i]);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        for(int i=0;i<nums.length;i++)
            if(this.helper(nums, k, t, i))
                return true;
        return false;
    }

    private boolean helper(int [] nums, int k, int t, int index) {
        double value = (double) nums[index];
        for(int i=index+1; i<nums.length && i+index<=k;i++)
            if(Math.abs(((double)nums[i]) - value) <= t)
                return true;

        for(int i=index-1;i>-1 && index-i <= k; i--)
            if(Math.abs(((double)nums[i]) - value) <= t)
                return true;
        return false;
    }
}