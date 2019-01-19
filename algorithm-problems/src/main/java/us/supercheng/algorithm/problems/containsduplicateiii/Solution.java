package us.supercheng.algorithm.problems.containsduplicateiii;


class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
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