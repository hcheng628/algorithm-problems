package us.supercheng.algorithm.problems.algo.binarytreediameter;

import java.util.*;

public class Program {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int binaryTreeDiameter_Solution1(BinaryTree tree) {
        if (tree == null)
            return 0;

        int left = binaryTreeDiameter_Solution1(tree.left),
            right = binaryTreeDiameter_Solution1(tree.right),
            self = getHeight(tree.left) + getHeight(tree.right);

        return Math.max(left, Math.max(right, self));
    }

    private int getHeight(BinaryTree root) {
        return root == null ? 0 : Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public int binaryTreeDiameter_Solution2(BinaryTree tree) {
        return this.helper(tree).dia;
    }

    private Info helper(BinaryTree root) {
        Info ret = new Info();

        if (root != null) {
            Info left = this.helper(root.left),
                 right = this.helper(root.right);

            ret.dia = Math.max(Math.max(left.dia, right.dia), left.height + right.height);
            ret.height =Math.max(left.height, right.height) + 1;
        }

        return ret;
    }

    class Info {
        int dia;
        int height;
    }

}
