package us.supercheng.algorithm.problems.leetcode.subarrayproductlessthank;

class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2)
            return 0;

        int ret = 0,
                left = 0;
        double curr = 1;

        for (int right=0, len = nums.length;right<len;right++) {
            curr *= nums[right];
            while(left < len && curr >= k)
                curr /= nums[left++];
            ret += right - left + 1;
        }

        return ret;
    }
}