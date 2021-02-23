package us.supercheng.algorithm.problems.algo.findkthlargestvalueinbst;

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

    public int findKthLargestValueInBst_Solution1(BST tree, int k) {
        List<Integer> list = new ArrayList<>();
        this.helper(tree, k, list);
        System.out.println(list);
        return list.get(list.size() - 1);
    }

    private void helper(BST root, int k, List<Integer> list) {
        if (root == null || list.size() == k)
            return;

        this.helper(root.right, k, list);
        if (list.size() < k)
            list.add(root.value);
        this.helper(root.left, k, list);
    }

    public int findKthLargestValueInBst_Solution2(BST tree, int k) {
        Info info = new Info();
        this.helper(tree, k, info);
        return info.val;
    }

    private void helper(BST root, int k, Info info) {
        if (root == null)
            return;

        this.helper(root.right, k, info);
        if (info.count < k) {
            info.count += 1;
            info.val = root.value;
            this.helper(root.left, k, info);
        }
    }

    class Info {
        int count;
        Integer val;
    }
}


