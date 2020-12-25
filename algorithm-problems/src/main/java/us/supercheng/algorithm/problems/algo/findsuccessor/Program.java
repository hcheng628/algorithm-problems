package us.supercheng.algorithm.problems.algo.findsuccessor;

import java.util.*;

public class Program {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessor_Solution1(BinaryTree tree, BinaryTree node) {
        if (tree == null)
            return null;

        if (tree == node)
            return tree.right != null ? this.getMin(tree.right) : this.findLeftParent(tree);

        BinaryTree left = this.findSuccessor_Solution1(tree.left, node);
        if (left != null)
            return left;

        BinaryTree right = this.findSuccessor_Solution1(tree.right, node);
        if (right != null)
            return right;

        return null;
    }

    private BinaryTree getMin(BinaryTree root) {
        return root.left == null ? root : this.getMin(root.left);
    }

    private BinaryTree findLeftParent(BinaryTree root) {
        if (root == null || root.parent == null)
            return null;

        return root.parent.left == root ? root.parent : this.findLeftParent(root.parent);
    }

    public BinaryTree findSuccessor_Solution2(BinaryTree tree, BinaryTree node) {
        List<BinaryTree> list = this.inOrder(tree, new ArrayList<>());
        boolean found = false;

        for (int idx=0, len=list.size(); idx<len; idx++) {
            BinaryTree curr = list.get(idx);

            if (found)
                return curr;

            if (curr == node)
                found = true;
        }

        return null;
    }

    private List<BinaryTree> inOrder(BinaryTree tree, List<BinaryTree> list) {
        if (tree != null) {
            this.inOrder(tree.left, list);
            list.add(tree);
            this.inOrder(tree.right, list);
        }

        return list;
    }
}

