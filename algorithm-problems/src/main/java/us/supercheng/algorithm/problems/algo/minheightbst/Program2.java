package us.supercheng.algorithm.problems.algo.minheightbst;

import java.util.*;

public class Program2 {

    public static BST minHeightBst(List<Integer> array) {
        return helper(array, 0, array.size() - 1);
    }

    public static BST helper(List<Integer> array, int left, int right) {
        if (left > right)
            return null;

        int mid = (right - left) / 2 + left;
        BST node = new BST(array.get(mid));

        node.left = helper(array, left, mid-1);
        node.right = helper(array, mid+1, right);

        return node;
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


