package us.supercheng.algorithm.problems.algo.compareleaftraversal;

import java.util.*;

public class Program {


    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // Time: O(n) Space: O(n)
    public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        this.dfs(tree1, list1);
        this.dfs(tree2, list2);

        if (list1.size() != list2.size())
            return false;

        for (int i=0, len=list1.size(); i<len; i++)
            if (list1.get(i) != list2.get(i))
                return false;

        return true;
    }

    private void dfs(BinaryTree tree, List<Integer> list) {
        if (tree == null)
            return;

        if (tree.left == null && tree.right == null) {
            list.add(tree.value);
            return;
        }

        this.dfs(tree.left, list);
        this.dfs(tree.right, list);
    }
}
