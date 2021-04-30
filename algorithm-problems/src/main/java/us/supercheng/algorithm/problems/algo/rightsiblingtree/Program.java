package us.supercheng.algorithm.problems.algo.rightsiblingtree;

import java.util.*;

public class Program {

    public static BinaryTree rightSiblingTree(BinaryTree root) {
        return helper(root, null);
    }

    private static BinaryTree helper(BinaryTree curr, BinaryTree parent) {
        if (curr == null)
            return null;

        helper(curr.left, curr);
        BinaryTree rightTree = curr.right;
        curr.right = null;

        if (parent != null)
            if (parent.left == curr && parent.right != null)
                curr.right = parent.right;
            else if (parent.right != null && parent.right.left != null)
                curr.right = parent.right.left;

        helper(rightTree, curr);
        return curr;
    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
