package us.supercheng.algorithm.problems.totalhammingdistance;

class Solution {
    public int totalHammingDistance(int[] nums) {
        if (nums == null)
            return 0;

        int retVal = 0;
        for (int i=0;i<32;i++) {
            int zeros = 0,
                    ones = 0;
            for (int j=0;j<nums.length;nums[j] >>=1,j++)
                if ((nums[j] & 1) == 1)
                    ones++;
                else
                    zeros++;
            retVal += zeros * ones;
        }
        return retVal;
    }
}