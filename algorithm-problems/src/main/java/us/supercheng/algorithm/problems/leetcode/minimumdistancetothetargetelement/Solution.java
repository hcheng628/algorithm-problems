package us.supercheng.algorithm.problems.leetcode.minimumdistancetothetargetelement;

public class Solution {

    public int getMinDistance(int[] nums, int target, int start) {
        int ret = -1;

        for (int i=0, len=nums.length; i<len; i++)
            if (nums[i] == target && (ret == -1 || Math.abs(i - start) < ret))
                ret = Math.abs(i - start);

        return ret;
    }

}
