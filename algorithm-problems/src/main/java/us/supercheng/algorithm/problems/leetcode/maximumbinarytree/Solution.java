package us.supercheng.algorithm.problems.leetcode.maximumbinarytree;

import us.supercheng.algorithm.common.entity.TreeNode;

class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return this.helper(nums, 0, nums.length-1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right || left < 0 || right >= nums.length)
            return null;

        int[] res = this.findMax(nums, left, right);
        TreeNode root = new TreeNode(res[0]);
        root.left = this.helper(nums, left, res[1]-1);
        root.right = this.helper(nums, res[1]+1, right);
        return root;
    }

    private int[] findMax(int[] nums, int left, int right) {
        int[] max = new int[]{nums[left], left};
        for (int i=left+1;i<=right;i++)
            if (nums[i] > max[0]) {
                max[0] = nums[i];
                max[1] = i;
            }
        return max;
    }
}