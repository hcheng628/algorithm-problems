package us.supercheng.algorithm.problems.algo.reconstructbst;

import java.util.*;

public class Program {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    // Time: (n^2) Space: (Height of N as a tree)
    public BST reconstructBst_Solution1(ArrayList<Integer> preOrderTraversalValues) {
        return this.helper(preOrderTraversalValues, 0, preOrderTraversalValues.size() - 1);
    }

    private BST helper(ArrayList<Integer> list, int from, int to) {
        if (from == to)
            return new BST(list.get(from));

        int val = list.get(from);
        int min = val;
        int max = val;
        int minIdx = from;
        int maxIdx = from;
        BST root = new BST(val);

        for (int i=from; (minIdx == from || maxIdx == from) && i<=to; i++) {
            int curr = list.get(i);
            if (curr < min && minIdx == from) {
                minIdx = i;
                min = curr;
            }

            if (curr >= max && maxIdx == from) {
                maxIdx = i;
                max = curr;
            }
        }

        if (minIdx != from)
            root.left = this.helper(list, minIdx, maxIdx == from ? to : maxIdx - 1);

        if (maxIdx != from)
            root.right = this.helper(list, maxIdx, to);

        return root;
    }

    // Time: (n) Space: (Height of N as a tree)
    private int curr;

    public BST reconstructBst_Solution2(ArrayList<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues == null || preOrderTraversalValues.isEmpty())
            return null;

        this.curr = 0;
        int val = preOrderTraversalValues.get(0);
        int len = preOrderTraversalValues.size();
        int min = val;
        int max = val;

        for (int i=1; i<len; i++) {
            int currVal = preOrderTraversalValues.get(i);
            min = Math.min(currVal, min);
            max = Math.max(currVal, max);
        }

        BST ret = new BST(val);
        this.curr++;
        ret.left = helper(preOrderTraversalValues, len, min, val -1);
        ret.right = helper(preOrderTraversalValues, len, val, max);
        return ret;
    }

    private BST helper(ArrayList<Integer> list, int len, int lower, int upper) {
        if (this.curr == len)
            return null;

        int val = list.get(this.curr);
        if (val >= lower && val <= upper) {
            BST ret = new BST(val);
            this.curr++;
            ret.left = helper(list, len, lower, val - 1);
            ret.right = helper(list, len, val, upper);
            return ret;
        }

        return null;
    }
}

