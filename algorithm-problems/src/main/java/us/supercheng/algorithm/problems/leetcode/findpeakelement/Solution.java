package us.supercheng.algorithm.problems.leetcode.findpeakelement;

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length < 1)
            return -1;
        else if(nums.length == 1)
            return 0;
        else if (nums.length == 2)
            return nums[0] > nums[1] ? 0 : 1;
        int left = 0, right = nums.length -1, mid = -1;

        while(left <= right) {
            mid = left + (right - left) / 2;
            if((mid == 0 || nums[mid] >= nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] >= nums[mid + 1]))
                return mid;
            else if(mid != nums.length -1 && nums[mid] < nums[mid + 1])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return mid;
    }
}