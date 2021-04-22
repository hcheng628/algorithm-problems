package us.supercheng.algorithm.problems.algo.iterativeinordertraversal;

import java.util.*;
import java.util.function.Function;

public class Program {

    // Time: O(n) Space: O(n)
    public static void iterativeInOrderTraversal_Solution1(BinaryTree tree, Function<BinaryTree, Void> callback) {
        Stack<BinaryTree> stack = new Stack<>();
        Set<BinaryTree> set = new HashSet<>();
        stack.push(tree);

        while (!stack.isEmpty()) {
            BinaryTree node = stack.pop();

            if (node.left != null && !set.contains(node.left)) {
                stack.push(node);
                stack.push(node.left);
            } else {
                set.add(node);
                callback.apply(node);
            }

            if (node.right != null && set.contains(node))
                stack.add(node.right);
        }
    }

    // Time: O(n) Space: O(1)
    public static void iterativeInOrderTraversal(BinaryTree tree, Function<BinaryTree, Void> callback) {
        for (BinaryTree curr = tree, prev = null; curr != null; ) {
            if (curr.left != null && curr.right != null) {
                if (curr.left == prev) {
                    callback.apply(curr);
                    prev = curr;
                    curr = curr.right;
                } else if (curr.right == prev) {
                    prev = curr;
                    curr = curr.parent;
                } else {
                    prev = curr;
                    curr = curr.left;
                }
            } else if (curr.left != null) {
                if (prev == curr.left) {
                    callback.apply(curr);
                    prev = curr;
                    curr = curr.parent;
                } else {
                    prev = curr;
                    curr = curr.left;
                }
            } else if (curr.right != null) {
                if (prev == curr.right) {
                    prev = curr;
                    curr = curr.parent;
                } else {
                    callback.apply(curr);
                    prev = curr;
                    curr = curr.right;
                }
            } else {
                callback.apply(curr);
                prev = curr;
                curr = curr.parent;
            }
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value, BinaryTree parent) {
            this.value = value;
            this.parent = parent;
        }
    }

}
