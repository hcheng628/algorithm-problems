package us.supercheng.algorithm.problems.leetcode.findpivotindex;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int [] nums = {1,7,3,6,5,6};
        PrintHelper.echoLn(new App().pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length < 3)
            return -1;

        int leftSum = 0, rightSum = 0;

        for(int i=1;i<nums.length;i++)
            rightSum += nums[i];

        for(int i=0;i <nums.length;) {
            if(leftSum == rightSum)
                return i;
            leftSum += nums[i];
            i++;
            if(i != nums.length)
                rightSum -= nums[i];
        }
        return -1;
    }
}