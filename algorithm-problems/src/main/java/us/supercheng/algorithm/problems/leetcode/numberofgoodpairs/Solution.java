package us.supercheng.algorithm.problems.leetcode.numberofgoodpairs;

public class Solution {

    public int numIdenticalPairs(int[] nums) {
        int ret = 0;

        for (int i=1, len=nums.length; i<len; i++)
            for (int j=0; j<i; j++)
                if (nums[i] == nums[j])
                    ret++;

        return ret;
    }

}
