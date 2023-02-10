package us.supercheng.algorithm.problems.leetcode.counthillsandvalleysinanarray;

class Solution {

    public int countHillValley(int[] nums) {
        int ret = 0;

        for (int i = 1, right = i + 1, len = nums.length; i < len - 1; i = right) {
            right = i + 1;
            while (right < len - 1 && nums[i] == nums[right])
                right++;

            if ((nums[i - 1] < nums[i] && nums[i] > nums[right]) || (nums[i - 1] > nums[i] && nums[i] < nums[right]))
                ret++;
        }

        return ret;
    }

}