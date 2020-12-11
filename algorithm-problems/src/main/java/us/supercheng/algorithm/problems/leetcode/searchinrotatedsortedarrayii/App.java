package us.supercheng.algorithm.problems.leetcode.searchinrotatedsortedarrayii;

import java.util.Arrays;

public class App {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return false;
        if(nums.length == 1)
            return nums[0] == target;

        int rotateIndex = 0;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i] == target || nums[i+1] == target)
                return true;
            if(nums[i] > nums[i+1]) {
                rotateIndex = i+1;
                break;
            }
        }
        return Arrays.binarySearch(nums, 0, rotateIndex, target) > -1 ||
                Arrays.binarySearch(nums, rotateIndex, nums.length, target) > -1;
    }
}