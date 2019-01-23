package us.supercheng.algorithm.problems.countcompletetreenodes;

import us.supercheng.algorithm.common.entity.TreeNode;

class Solution {
    public int countNodes(TreeNode root) {
        int leftH = this.getHeight(root, 0, true),
                rightH = this.getHeight(root, 0, false);
        return root == null ? 0
                : (leftH == rightH ? (int) Math.pow(2, leftH) - 1 : this.countNodes(root.left) + this.countNodes(root.right) + 1);
    }

    private int getHeight(TreeNode node, int height, boolean isLeft) {
        return node == null ? height : (isLeft ? this.getHeight(node.left, height+1, true)
                : this.getHeight(node.right, height+1, false));
    }
}