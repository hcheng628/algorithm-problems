package us.supercheng.algorithm.problems.algo.findnodesdistancek;

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

    public ArrayList<Integer> findNodesDistanceK_Solution1(BinaryTree tree, int target, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, BinaryTree> map = new HashMap<>();
        Queue<BinaryTree> q = new LinkedList<>();

        this.travel(map, tree, null);
        BinaryTree targetParent = map.get(target);
        BinaryTree t = null;
        if (targetParent != null)
            t = targetParent.left != null && targetParent.left.value == target ? targetParent.left : targetParent.right;
        else
            t = tree;

        q.offer(t);
        visited.add(t.value);

        for (int dis=0; dis<k; dis++)
            for (int i=0, size = q.size(); i<size; i++) {
                BinaryTree curr = q.poll();
                BinaryTree parent = map.get(curr.value);
                if (parent != null && !visited.contains(parent.value)) {
                    q.offer(parent);
                    visited.add(parent.value);
                }

                if (curr.left != null && !visited.contains(curr.left.value)) {
                    q.offer(curr.left);
                    visited.add(curr.left.value);
                }

                if (curr.right != null && !visited.contains(curr.right.value)) {
                    q.offer(curr.right);
                    visited.add(curr.right.value);
                }
            }

        while (!q.isEmpty())
            ret.add(q.poll().value);

        return ret;
    }

    private void travel(Map<Integer, BinaryTree> map, BinaryTree tree, BinaryTree parent) {
        if (tree == null)
            return;

        map.put(tree.value, parent);
        this.travel(map, tree.left, tree);
        this.travel(map, tree.right, tree);
    }


    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        this.findDis(tree, target, k, ret);
        return ret;
    }

    private int findDis(BinaryTree root, int tar, int k, ArrayList<Integer> ret) {
        if (root == null)
            return -1;
        else if (root.value == tar) {
            this.build(root, k, ret);
            return 1;
        }

        int left = this.findDis(root.left, tar, k, ret);
        int right = this.findDis(root.right, tar, k, ret);

        if (left == k || right == k)
            ret.add(root.value);

        if (left != -1) {
            this.build(root.right, k - left - 1, ret);
            return left + 1;
        } else if (right != -1) {
            this.build(root.left, k - right - 1, ret);
            return right + 1;
        }

        return -1;
    }

    private void build(BinaryTree root, int dis, ArrayList<Integer> ret) {
        if (root == null)
            return;
        else if (dis == 0) {
            ret.add(root.value);
            return;
        }
        this.build(root.left, dis - 1, ret);
        this.build(root.right, dis - 1, ret);
    }
}
