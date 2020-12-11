package us.supercheng.algorithm.problems.leetcode.searchinrotatedsortedarray;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        int [] nums = {4,5,6,7,0,1,2};
        int target = 1;
        PrintHelper.echoLn("Index: " + new App().search(nums, target));
    }

    public int search(int[] nums, int target) {
        if(nums.length == 1)
            return nums[0] == target ? 0 : -1;
        if(nums.length == 2) {
            if(nums[0] != target && nums[1] != target)
                return -1;
            if(nums[0] == target)
                return 0;
            return 1;
        }

        for(int i=0;i<nums.length-1;i++) {
            if(nums[i] == target)
                return i;
            if(nums[i] > nums[i+1]) {
                int index = Arrays.binarySearch(nums, 0, i, target);
                if(index > -1)
                    return index;
                index = Arrays.binarySearch(nums, i+1, nums.length, target);
                if(index > -1)
                    return index;
                return -1;
            }
        }
        int index = Arrays.binarySearch(nums, target);
        return index > -1 ? index : -1;
    }
}