package us.supercheng.algorithm.problems.leetcode.deletenodeinabst;

import us.supercheng.algorithm.common.entity.TreeNode;

class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.val == key) {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                TreeNode rightMinNode = this.minChildHelper(root.right);
                rightMinNode.left = root.left;
                if (rightMinNode != root.right)
                    rightMinNode.right = root.right;
                return rightMinNode;
            }
        } else {
            if (root.val > key)
                root.left = this.deleteNode(root.left, key);
            else
                root.right = this.deleteNode(root.right, key);
            return root;
        }
    }

    private TreeNode minChildHelper(TreeNode head) {
        while (head.left != null && head.left.left != null)
            head = head.left;

        TreeNode retNode = head.left == null ? head : head.left;
        head.left = retNode.right;
        return retNode;
    }
}