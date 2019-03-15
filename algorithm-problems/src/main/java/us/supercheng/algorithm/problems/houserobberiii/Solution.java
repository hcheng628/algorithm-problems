package us.supercheng.algorithm.problems.houserobberiii;

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
}