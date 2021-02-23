package us.supercheng.algorithm.problems.algo.heightbalancedbinarytree;

import java.util.*;

public class Program {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        return tree == null ? true : this.helper(tree) != -1;
    }

    private int helper(BinaryTree root) {
        if (root == null)
            return 0;

        int left = this.helper(root.left);
        int right = this.helper(root.right);

        if (left < 0 || right < 0)
            return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}

