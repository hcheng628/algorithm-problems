package us.supercheng.algorithm.problems.invertbinarytree;

import us.supercheng.algorithm.common.entity.TreeNode;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        app.invertTree(null);
    }

    public TreeNode invertTree(TreeNode root) {
        this.helper(root);
        return root;
    }

    public void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        helper(root.left);
        helper(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public TreeNode invertTree2(TreeNode root) {
        this.invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        this.invert(root.left);
        this.invert(root.right);
    }
}