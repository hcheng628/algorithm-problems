package us.supercheng.algorithm.problems.leetcode.pathsum;

import us.supercheng.algorithm.common.entity.TreeNode;

public class App {

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.hasPathSum(null, 0));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        int newVal = sum - root.val;
        if(root.left == null & root.right == null)
            return newVal == 0;
        else if (root.left != null && root.right == null)
            return this.hasPathSum(root.left, newVal);
        else if (root.left == null && root.right != null)
            return this.hasPathSum(root.right, newVal);
        else
            return this.hasPathSum(root.left, newVal) || this.hasPathSum(root.right, newVal);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null)
            return false;

        int newSum = sum - root.val;
        if (root.left == null && root.right == null && newSum == 0)
            return true;
        return this.hasPathSum2(root.left, newSum) || this.hasPathSum2(root.right, newSum);
    }
}