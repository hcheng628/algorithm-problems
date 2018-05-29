package us.supercheng.algorithm.problems.pathsum;

import us.supercheng.algorithm.common.entity.TreeNode;

public class App {

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.hasPathSum(null, 0));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        int newVal = sum - root.val;
        if(root.left == null & root.right == null) {
            if(newVal == 0) {
                return true;
            } else {
                return false;
            }
        } else if (root.left != null && root.right == null) {
            return this.hasPathSum(root.left, newVal);
        } else if (root.left == null && root.right != null) {
            return this.hasPathSum(root.right, newVal);
        } else {
            return this.hasPathSum(root.left, newVal) || this.hasPathSum(root.right, newVal);
        }
    }
}