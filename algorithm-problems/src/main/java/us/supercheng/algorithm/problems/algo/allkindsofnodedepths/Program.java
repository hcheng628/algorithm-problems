package us.supercheng.algorithm.problems.algo.allkindsofnodedepths;

import java.util.*;

public class Program {

    public static int allKindsOfNodeDepths_Solution1(BinaryTree root) {
        return travel(root);
    }

    public static int travel(BinaryTree root) {
        if (root == null)
            return 0;
        return getDepth(root, 0) + travel(root.left) + travel(root.right);
    }

    private static int getDepth(BinaryTree root, int level) {
        if (root == null)
            return 0;
        return level + getDepth(root.left, level + 1) + getDepth(root.right, level + 1);
    }

    public static int allKindsOfNodeDepths(BinaryTree root) {
        return helper(root, 0)[2];
    }

    private static int[] helper(BinaryTree root, int level) {
        if (root == null)
            return new int[]{0, 0, 0};

        int[] left = helper(root.left, level + 1);
        int[] right = helper(root.right, level + 1);
        int[] ret = new int[3];
        ret[0] = left[0] + right[0] + 1;
        ret[1] = left[0] + left[1] + right[0] + right[1];
        ret[2] = ret[1] + left[2] + right[2];
        return ret;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}