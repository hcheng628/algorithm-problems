package us.supercheng.algorithm.problems.longestcontinuousincreasingsubsequence;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int[] nums = {32412,2321,21,321,321,32,43,543,46,54,5645,6,432};
        PrintHelper.echoLn(new App().findLengthOfLCIS(nums));
    }

    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;
        else if (nums.length < 2)
            return 1;
        int max = 0;
        int count = 1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i] > nums[i-1])
                count++;
            else
                count = 1;
            max = Math.max(count, max);
        }
        return max;
    }
}