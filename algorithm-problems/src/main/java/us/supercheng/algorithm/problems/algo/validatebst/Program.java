package us.supercheng.algorithm.problems.algo.validatebst;

import java.util.*;

public class Program {
    public static boolean validateBst(BST tree) {
        return validate(tree, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private static boolean validate(BST tree, int max, int min) {
        if (tree == null)
            return true;

        int val = tree.value;

        if (val < min || val >= max)
            return false;

        return validate(tree.left, val, min) && validate(tree.right, max, val);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}

