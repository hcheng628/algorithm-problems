package us.supercheng.algorithm.problems.algo.branchsums;

import java.util.*;

public class Program {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        return branchSums(root, new ArrayList<Integer>(), 0);
    }

    public static List<Integer> branchSums(BinaryTree root, List<Integer> list, int curr) {
        if (root == null)
            return list;

        curr += root.value;
        if (root.left == null && root.right == null) {
            list.add(curr);
            return list;
        }

        branchSums(root.left, list, curr);
        branchSums(root.right, list, curr);

        return list;
    }
}
