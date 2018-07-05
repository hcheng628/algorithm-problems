package us.supercheng.algorithm.problems.diameterofbinarytree;

import us.supercheng.algorithm.common.entity.TreeNode;
import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String [] args) {
        PrintHelper.echoLn(new App().diameterOfBinaryTree(null));
        PrintHelper.echoLn(new App().diameterOfBinaryTree2(null));
    }

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        int currentLeftHeight = this.getHeight(root.left, 0);
        int currentRightHeight = this.getHeight(root.right, 0);
        max = Math.max(max, currentLeftHeight + currentRightHeight);

        this.diameterOfBinaryTree(root.left);
        this.diameterOfBinaryTree(root.right);
        return max;
    }

    private int getHeight(TreeNode root, int level) {
        if(root == null)
            return level;
        return Math.max(this.getHeight(root.left, level + 1), this.getHeight(root.right, level + 1));
    }

    public int diameterOfBinaryTree2(TreeNode root) {
        if(root == null)
            return 0;
        this.getHeight2(root);
        return this.max;
    }

    private int getHeight2(TreeNode root) {
        if(root == null)
            return 0;
        int right = this.getHeight2(root.right);
        int left = this.getHeight2(root.left);
        if(left + right > max)
            max = left + right;
        return left > right ? left + 1 : right + 1;
    }
}