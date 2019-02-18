package us.supercheng.algorithm.problems.findtheduplicatenumber;

class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length == 2)
            return nums[0];
        int slow = 0, fast = 0, start=0;

        while (true) {
            slow=nums[slow];
            fast=nums[nums[fast]];
            if (slow == fast)
                break;
        }

        while (true) {
            start = nums[start];
            slow = nums[slow];
            if (start == slow)
                return slow;
        }
    }
}