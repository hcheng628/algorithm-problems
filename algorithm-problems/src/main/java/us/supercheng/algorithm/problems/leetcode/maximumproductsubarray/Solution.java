package us.supercheng.algorithm.problems.leetcode.maximumproductsubarray;

class Solution {
    public int maxProductDP(int[] nums) {
        if(nums ==  null || nums.length < 1)
            return 0;
        else if(nums.length == 1)
            return nums[0];

        int ret = nums[0];
        int [] dpMax = new int [nums.length],
                dpMin = new int [nums.length];

        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        for(int i=1;i<nums.length;i++) {
            dpMax[i] = Math.max(Math.max(nums[i] * dpMax[i-1], nums[i] * dpMin[i-1]), nums[i]);
            dpMin[i] = Math.min(Math.min(nums[i] * dpMax[i-1], nums[i] * dpMin[i-1]), nums[i]);
            ret = Math.max(dpMax[i], ret);
        }

        return ret;
    }

    public int maxProduct(int[] nums) {
        if(nums ==  null || nums.length < 1)
            return 0;
        else if(nums.length == 1)
            return nums[0];

        int ret = nums[0],
                min = ret,
                max = ret,
                temp = ret;

        for(int i=1;i<nums.length;i++) {
            temp = max;
            max = Math.max(Math.max(min * nums[i], max * nums[i]), nums[i]);
            min = Math.min(Math.min(min * nums[i], temp * nums[i]), nums[i]);
            ret = Math.max(max, ret);
        }
        return ret;
    }
}