package us.supercheng.algorithm.problems.flattenbinarytreetolinkedlist;

import us.supercheng.algorithm.common.entity.TreeNode;

class Solution {

    public void flatten(TreeNode root) {
        this.helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if(root == null)
            return root;

        TreeNode left = this.helper(root.left);
        TreeNode right = this.helper(root.right);

        if(left == null && right == null)
            return root;

        if(left != null) {
            TreeNode temp = root.right;
            root.right = left;
            while(left.right != null)
                left = left.right;
            left.right = temp;
            root.left = null;
        }

        return root;
    }
}