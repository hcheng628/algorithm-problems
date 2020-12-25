package us.supercheng.algorithm.problems.algo.invertbinarytree;

import java.util.*;

public class Program {

    public static void invertBinaryTree_Solution1(BinaryTree tree) {
        if (tree == null)
            return;

        BinaryTree left = tree.left;
        tree.left = tree.right;
        tree.right = left;
        invertBinaryTree_Solution1(tree.left);
        invertBinaryTree_Solution1(tree.right);
    }

    public static void invertBinaryTree_Solution2(BinaryTree tree) {
        Queue<BinaryTree> q = new LinkedList<>();

        if (tree != null)
            q.offer(tree);

        while (!q.isEmpty()) {
            BinaryTree t = q.poll(),
                       left = t.left;
            t.left = t.right;
            t.right = left;

            if (t.left != null)
                q.offer(t.left);

            if (t.right != null)
                q.offer(t.right);
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}

