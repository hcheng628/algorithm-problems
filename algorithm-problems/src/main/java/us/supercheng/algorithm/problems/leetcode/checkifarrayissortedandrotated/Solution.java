package us.supercheng.algorithm.problems.leetcode.checkifarrayissortedandrotated;

public class Solution {

    public boolean check(int[] nums) {
        for (int count = 0, i=1, len=nums.length; i<=len; i++)
            if (nums[i - 1] > nums[i % len]) {
                count++;
                if (count > 1)
                    return false;
            }

        return true;
    }
}
