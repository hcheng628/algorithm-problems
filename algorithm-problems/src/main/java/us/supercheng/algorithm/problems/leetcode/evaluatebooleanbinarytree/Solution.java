package us.supercheng.algorithm.problems.leetcode.evaluatebooleanbinarytree;

import us.supercheng.algorithm.common.entity.TreeNode;

class Solution {

    public boolean evaluateTree(TreeNode root) {
        if (root.left == null)
            return root.val == 1;

        boolean left = this.evaluateTree(root.left);
        boolean right = this.evaluateTree(root.right);

        return root.val == 2 ? left || right : left && right;
    }

}
