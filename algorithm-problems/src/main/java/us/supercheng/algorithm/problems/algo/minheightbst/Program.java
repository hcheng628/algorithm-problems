package us.supercheng.algorithm.problems.algo.minheightbst;

import java.util.*;

public class Program {

    public static BST minHeightBst(List<Integer> array) {
        int right = array.size() - 1,
            mid = right / 2;

        BST root = new BST(array.get(mid));
        helper(array, root, 0, mid-1);
        helper(array, root, mid+1, right);

        return root;
    }

    private static void helper(List<Integer> array, BST root, int left, int right) {
        if (left > right)
            return;

        int mid = (right - left) / 2 + left;
        root.insert(array.get(mid));
        helper(array, root, left, mid-1);
        helper(array, root, mid+1, right);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
