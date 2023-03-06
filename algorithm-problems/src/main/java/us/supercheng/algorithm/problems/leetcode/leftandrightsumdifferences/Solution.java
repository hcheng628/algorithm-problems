package us.supercheng.algorithm.problems.leetcode.leftandrightsumdifferences;

class Solution {

    public int[] leftRigthDifference(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];
        int rightSum = 0;
        int leftSum = 0;

        for (int i = 0; i < len; i++)
            rightSum += nums[i];

        for (int i = 0; i < len; i++) {
            rightSum -= nums[i];
            ret[i] = Math.abs(rightSum - leftSum);
            leftSum += nums[i];
        }

        return ret;
    }

}
