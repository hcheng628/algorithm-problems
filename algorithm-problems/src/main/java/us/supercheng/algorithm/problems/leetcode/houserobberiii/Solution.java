package us.supercheng.algorithm.problems.leetcode.houserobberiii;

import us.supercheng.algorithm.common.entity.TreeNode;

class Solution {
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        int val = root.val;

        if (root.left != null)
            val += this.rob(root.left.left) + this.rob(root.left.right);

        if (root.right != null)
            val += this.rob(root.right.left) + this.rob(root.right.right);

        return Math.max(val, this.rob(root.left) + this.rob(root.right));
    }

    public int robDP(TreeNode root) {
        int[] res = this.dfsDP(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfsDP(TreeNode root) {
        if (root == null)
            return new int [2];
        int [] left = this.dfsDP(root.left);
        int [] right = this.dfsDP(root.right);

        int[] res = new int [2];
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}