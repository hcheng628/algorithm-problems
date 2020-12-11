package us.supercheng.algorithm.problems.leetcode.productofarrayexceptself;

class Solution {

    public int[] productExceptSelf(int[] nums) {
        int [] ret = new int[nums.length];
        ret[0] = 1;
        for (int i=1;i<nums.length;i++)
            ret[i] = nums[i-1] * ret[i-1];

        for (int i=nums.length-2, curr = nums[nums.length-1];i>-1;curr *= nums[i],i--)
            ret[i] = curr * ret[i];

        return ret;
    }

    public int[] productExceptSelfRec(int[] nums) {
        this.helper(nums, 1, 0, nums.length);
        return nums;
    }

    private int helper(int[] nums, int prev, int index, int LEN) {
        int next = 1;
        if(index < LEN) {
            next = this.helper(nums, prev * nums[index], index+1, LEN);
            int curr = nums[index];
            nums[index] = prev * next;
            next *= curr;
        }
        return next;
    }
}