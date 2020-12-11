package us.supercheng.algorithm.problems.leetcode.completebinarytreeinsert;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {

    List<TreeNode> list;

    public CBTInserter(TreeNode root) {
        this.list = new ArrayList<>();

        if (root != null)
            this.list.add(root);

        for (int i=0;i<this.list.size(); i++) {
            TreeNode curr = this.list.get(i);
            if (curr.left != null)
                this.list.add(curr.left);

            if (curr.right != null)
                this.list.add(curr.right);
        }
    }

    public int insert(int v) {
        int size = this.list.size(),
            parentIdx = size % 2 == 0 ? size / 2 - 1 : size / 2;

        TreeNode parent = this.list.get(parentIdx),
                node = new TreeNode(v);
        this.list.add(node);

        if (parent.left == null)
            parent.left = node;
        else
            parent.right = node;

        return parent.val;
    }

    public TreeNode get_root() {
        return this.list.size() > 0 ? this.list.get(0) : null;
    }

    TreeNode r;

    public CBTInserter(TreeNode root, int abc) {
        this.r = root;
    }

    public int insert2(int v) {
        TreeNode node = new TreeNode(v);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(this.r);

        while (!q.isEmpty())
            for (int i=0, size = q.size(); i<size; i++) {
                TreeNode curr = q.poll();

                if (curr.left == null) {
                    curr.left = node;
                    return curr.val;
                } else
                    q.offer(curr.left);

                if (curr.right == null) {
                    curr.right = node;
                    return curr.val;
                } else
                    q.offer(curr.right);
            }

        return -1;
    }

    public TreeNode get_root2() {
        return this.r;
    }
}