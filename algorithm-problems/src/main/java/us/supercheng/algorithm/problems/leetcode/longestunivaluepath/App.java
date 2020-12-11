package us.supercheng.algorithm.problems.leetcode.longestunivaluepath;

import us.supercheng.algorithm.common.entity.TreeNode;

public class App {

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        diffDis(root);
        return this.max;
    }

    private int diffDis(TreeNode root) {
        if(root == null)
            return 0;

        int leftVal=0, rightVal=0;

        if(root.left != null && root.left.val == root.val) {
            leftVal = diffDis(root.left);
            leftVal +=1;
        } else
            diffDis(root.left);

        if(root.right != null && root.right.val == root.val) {
            rightVal = diffDis(root.right);
            rightVal +=1;
        } else
            diffDis(root.right);

        this.max = Math.max(this.max, leftVal + rightVal);
        return Math.max(leftVal, rightVal);
    }

    public int longestUnivaluePath2(TreeNode root) {
        if(root == null)
            return 0;
        diffDis2(root, root.val);
        return this.max;
    }

    private int diffDis2(TreeNode root, int val) {
        if(root == null)
            return 0;
        int left = diffDis2(root.left, root.val);
        int right = diffDis2(root.right, root.val);

        if(left + right > max)
            max = left + right;

        if(root.val == val)
            return left > right ? left + 1 : right + 1;
        return 0;
    }
}