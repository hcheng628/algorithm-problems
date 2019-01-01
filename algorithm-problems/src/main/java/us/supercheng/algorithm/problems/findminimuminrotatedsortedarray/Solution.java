package us.supercheng.algorithm.problems.findminimuminrotatedsortedarray;

class Solution {
    public int findMinON(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;

        for(int i=0;i<nums.length-1;i++)
            if(nums[i]>nums[i+1]) {
                if(nums[i+1] > nums[0])
                    return nums[0];
                return nums[i+1];
            }
        return nums[0];
    }

    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length-1;

        if(nums[right] > nums[left])
            return nums[left];

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[mid+1])
                return nums[mid+1];

            if(nums[mid] < nums[mid-1])
                return nums[mid];

            if(nums[0] < nums[mid])
                left = mid + 1;
            else
                right = mid - 1;

        }

        return nums[0];
    }
}