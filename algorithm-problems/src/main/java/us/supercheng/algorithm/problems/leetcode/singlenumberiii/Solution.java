package us.supercheng.algorithm.problems.leetcode.singlenumberiii;

class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2)
            return nums;

        int [] ret = new int [2];
        int diff = 0;

        for (int num : nums)
            diff ^= num;

        diff &= -diff;

        for (int num : nums)
            if ((num & diff) == 0)
                ret[0] ^= num;
            else
                ret[1] ^= num;
        return ret;
    }
}