package us.supercheng.algorithm.problems.longestunivaluepath;

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

}