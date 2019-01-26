package us.supercheng.algorithm.problems.kthsmallestelementinabst;

import us.supercheng.algorithm.common.entity.TreeNode;

class Solution {

    int count;
    int ret;

    public int kthSmallest(TreeNode root, int k) {
        this.inOrder(root, k);
        return this.ret;
    }

    private void inOrder(TreeNode root, int k) {
        if(root == null)
            return;

        this.inOrder(root.left, k);
        count++;
        if(count == k) {
            ret = root.val;
            return;
        }
        this.inOrder(root.right, k);
    }


    public int kthSmallest2(TreeNode root, int k) {

        while(k>1 && root != null) {
            root = this.removeMin(root);
            k--;
        }

        while(root.left != null)
            root = root.left;

        return root.val;
    }

    private TreeNode removeMin(TreeNode root) {
        if(root.left == null) {
            return root.right;
        }
        root.left = this.removeMin(root.left);
        return root;
    }
}