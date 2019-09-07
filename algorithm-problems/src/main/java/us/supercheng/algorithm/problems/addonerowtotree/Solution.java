package us.supercheng.algorithm.problems.addonerowtotree;

import us.supercheng.algorithm.common.entity.TreeNode;

class Solution {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        this.addNode(root, v, d, 2);
        return root;
    }

    private void addNode(TreeNode root, int v, int d, int curr) {
        if (d == curr) {
            if (root.left != null) {
                TreeNode node = new TreeNode(v);
                node.left = root.left;
                root.left = node;
            } else
                root.left = new TreeNode(v);

            if (root.right != null) {
                TreeNode node = new TreeNode(v);
                node.right = root.right;
                root.right = node;
            } else
                root.right = new TreeNode(v);
        } else if (d > curr) {
            if (root.left != null)
                this.addNode(root.left, v, d, curr+1);
            if (root.right != null)
                this.addNode(root.right, v, d, curr+1);
        }
    }
}