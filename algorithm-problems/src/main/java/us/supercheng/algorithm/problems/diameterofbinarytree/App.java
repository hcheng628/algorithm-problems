package us.supercheng.algorithm.problems.diameterofbinarytree;

import us.supercheng.algorithm.common.entity.TreeNode;
import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String [] args) {
        PrintHelper.echoLn(new App().diameterOfBinaryTree(null));
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
}