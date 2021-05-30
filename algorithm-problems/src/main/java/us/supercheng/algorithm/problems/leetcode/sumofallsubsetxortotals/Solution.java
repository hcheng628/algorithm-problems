package us.supercheng.algorithm.problems.leetcode.sumofallsubsetxortotals;

public class Solution {

    // Time: O(n^2) Space: O(n) Recursion call stack
    public int subsetXORSum(int[] nums) {
        return this.helper(nums, 0, nums.length - 1, 0);
    }

    private int helper(int[] nums, int idx, int last, int val) {
        return idx > last ? val :
                this.helper(nums, idx + 1, last, val ^ nums[idx]) +
                        this.helper(nums, idx + 1, last, val);
    }
}
