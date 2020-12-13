package us.supercheng.algorithm.problems.algo.findclosestvalueinbst;

import java.util.*;

public class Program {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static int findClosestValueInBst_Solution1(BST tree, int target) {
        if (tree == null)
            return -1;

        return findClosestValueInBst_Solution1(tree, target, tree.value);
    }

    public static int findClosestValueInBst_Solution1(BST tree, int target, int currVal) {
        if (tree == null)
            return currVal;
        else if (tree.value == target)
            return tree.value;

        int val = tree.value;
        if (Math.abs(val - target) < Math.abs(currVal - target))
            currVal = val;

        if (target < val)
            return findClosestValueInBst_Solution1(tree.left, target, currVal);
        else
            return findClosestValueInBst_Solution1(tree.right, target, currVal);
    }



    public static int findClosestValueInBst_Solution2(BST tree, int target) {
        if (tree == null)
            return -1;

        int ret = tree.value,
            minDiff = Math.abs(ret - target);
        Queue<BST> q = new LinkedList<>();
        q.offer(tree);

        while (!q.isEmpty()) {
            for (int size=q.size(); size > 0; size--) {
                BST t = q.poll();
                int val = t.value,
                    diff = Math.abs(val - target);

                if (diff < minDiff) {
                    ret = val;
                    minDiff = diff;
                }

                if (t.left != null)
                    q.offer(t.left);

                if (t.right != null)
                    q.offer(t.right);
            }
        }

        return ret;
    }

    public static int findClosestValueInBst_Solution3(BST tree, int target) {
        if (tree == null)
            return -1;

        int ret = tree.value;

        while (tree != null) {
            int val = tree.value;

            if (val == target)
                return target;

            if (Math.abs(target - val) < Math.abs(target - ret))
                ret = val;

            tree = val > target ? tree.left : tree.right;
        }

        return ret;
    }
}
