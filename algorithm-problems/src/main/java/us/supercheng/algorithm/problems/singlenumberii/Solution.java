package us.supercheng.algorithm.problems.singlenumberii;

import us.supercheng.algorithm.common.helper.PrintHelper;

class Solution {

    public static void main(String [] args) {
        int [] nums =  {1,2,1,3,2,2,1};
        Solution solution = new Solution();

        solution.singleNumber(nums);
    }

    public int singleNumber(int[] nums) {
        int first = 0;
        int second = 0;
        for (int n : nums) {
            PrintHelper.echoLn("n: " + Integer.toBinaryString(n));
            PrintHelper.echoLn("Before first: " + Integer.toBinaryString(first) + " second: " + Integer.toBinaryString(second));
            first = (first ^ n) & ~second;
            PrintHelper.echoLn("After first: " + Integer.toBinaryString(first));
            second = (second ^ n) & ~first;
            PrintHelper.echoLn("After second: " + Integer.toBinaryString(second) + "\r\n");

        }
        return first;
    }
    public int singleNumber2(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int fir = 0, sec = 0, last = nums.length -1;
        for(int i=0;i<nums.length;i++) {
            fir = (fir ^ nums[i]) & ~sec;
            if(i== last)
                return fir;
            sec = (sec ^ nums[i]) & ~fir;
        }
        return -1;
    }
}