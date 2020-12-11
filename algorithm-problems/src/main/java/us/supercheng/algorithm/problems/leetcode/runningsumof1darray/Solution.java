package us.supercheng.algorithm.problems.leetcode.runningsumof1darray;

public class Solution {

    public int[] runningSum(int[] nums) {
        for (int i=1, len=nums.length; i<len; i++)
            nums[i] += nums[i-1];
        return nums;
    }
}