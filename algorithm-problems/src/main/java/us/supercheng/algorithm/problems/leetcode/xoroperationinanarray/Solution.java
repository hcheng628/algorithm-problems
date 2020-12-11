package us.supercheng.algorithm.problems.leetcode.xoroperationinanarray;

public class Solution {

    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        int ret = nums[0];

        for (int i=0; i<n; i++)
            nums[i] = start + 2*i;

        for (int i=1; i<n; i++)
            ret ^= nums[i];

        return ret;
    }

}
