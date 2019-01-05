package us.supercheng.algorithm.problems.univaluedbinarytree;

import us.supercheng.algorithm.common.entity.TreeNode;

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return root == null || this.helper(root.left, root.val) && this.helper(root.right, root.val);
    }

    private boolean helper(TreeNode root, int value) {
        return root == null || (root.val == value && this.helper(root.left, value) && this.helper(root.right, value));
    }
}