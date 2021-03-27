package us.supercheng.algorithm.problems.algo.flattenbinarytree;

import java.util.*;

public class Program {

    // Time: O(n) Space: O(n) and call stack depth of the tree
    public static BinaryTree flattenBinaryTree_Solution1(BinaryTree root) {
        List<BinaryTree> list = new ArrayList<>();
        helper1(root, list);

        for (int i=0, len=list.size(); i<len; i++) {
            BinaryTree curr = list.get(i);
            if (i == 0) {
                curr.left = null;
                if (i + 1 < len)
                    curr.right = list.get(i + 1);
            } else if (i == len - 1) {
                if (i - 1 > -1)
                    curr.left = list.get(i - 1);
                curr.right = null;
            } else {
                curr.left = list.get(i - 1);
                curr.right = list.get(i + 1);
            }
        }

        return list.get(0);
    }

    private static void helper1(BinaryTree root, List<BinaryTree> list) {
        if (root == null)
            return;
        helper1(root.left, list);
        list.add(root);
        helper1(root.right, list);
    }

    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        helper2(root);
        while (root != null && root.left != null)
            root = root.left;
        return root;
    }

    private static BinaryTree[] helper2(BinaryTree root) {
        if (root  == null)
            return new BinaryTree[]{null, null};

        BinaryTree[] leftRes = helper2(root.left);
        root.left = leftRes[1];
        if (leftRes[1] != null)
            leftRes[1].right = root;

        BinaryTree[] rightRes = helper2(root.right);
        root.right = rightRes[0];
        if (rightRes[0] != null)
            rightRes[0].left = root;

        return new BinaryTree[]{
                root.left != null ? leftRes[0] : root,
                root.right != null ? rightRes[1] : root
        };
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

