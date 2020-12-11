package us.supercheng.algorithm.problems.leetcode.binarysearchtreeiterator;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.Stack;

class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack();
        this.reload(root);
    }

    public int next() {
        TreeNode node = this.stack.pop();
        this.reload(node.right);
        return node.val;
    }

    private void reload(TreeNode root) {
        for(;root != null;root = root.left)
            stack.push(root);
    }

    public boolean hasNext() {
        return !this.stack.isEmpty();
    }
}