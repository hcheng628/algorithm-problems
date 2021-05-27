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
    public boolean compareLeafTraversal_Solution1(BinaryTree tree1, BinaryTree tree2) {
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

    // Time: O(max node of tree1 or 2) Space: O(max height of the tree1 or 2) can return early
    public boolean compareLeafTraversal_Solution2(BinaryTree tree1, BinaryTree tree2) {
        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();

        stack1.push(tree1);
        stack2.push(tree2);

        while (!stack1.isEmpty() && !stack2.isEmpty())
            if (this.nextLeaf(stack1).value != this.nextLeaf(stack2).value)
                return false;

        return stack1.isEmpty() && stack2.isEmpty();
    }

    private BinaryTree nextLeaf(Stack<BinaryTree> stack) {
        while (!stack.isEmpty()) {
            BinaryTree t = stack.pop();
            if (t.left == null && t.right == null)
                return t;
            if (t.right != null)
                stack.push(t.right);
            if (t.left != null)
                stack.push(t.left);
        }

        return null;    // Should not return null as BST properties
    }

    // Time: O(max node of tree1 or 2) Space: O(max height of the tree1 or 2)
    public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
        BinaryTree leaves1 = this.processLeaves(tree1);
        BinaryTree leaves2 = this.processLeaves(tree2);

        while (leaves1 != null && leaves2 != null) {
            if (leaves1.value != leaves2.value)
                return false;

            leaves1 = leaves1.right;
            leaves2 = leaves2.right;
        }

        return leaves1 == null && leaves2 == null;
    }

    private BinaryTree processLeaves(BinaryTree t) {
        Stack<BinaryTree> stack = new Stack<>();
        stack.push(t);

        BinaryTree ret = null;
        BinaryTree prev = null;

        while (!stack.isEmpty()) {
            BinaryTree curr = stack.pop();

            if (curr.left == null && curr.right == null) {
                if (ret == null)
                    ret = curr;

                if (prev != null)
                    prev.right = curr;
                prev = curr;
            }

            if (curr.right != null)
                stack.push(curr.right);

            if (curr.left != null)
                stack.push(curr.left);
        }

        return ret;
    }

    private void debugT(BinaryTree t) {
        StringBuilder sb = new StringBuilder();

        while (t != null) {
            sb.append(t.value + "->");
            t = t.right;
        }

        System.out.println(sb);
    }
}
