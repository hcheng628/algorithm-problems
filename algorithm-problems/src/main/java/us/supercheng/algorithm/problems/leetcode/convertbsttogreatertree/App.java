package us.supercheng.algorithm.problems.leetcode.convertbsttogreatertree;

import us.supercheng.algorithm.common.entity.TreeNode;
import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        PrintHelper.echoLn(new App().convertBST(null));
    }



    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        this.helper(root);
        return root;
    }

    private void helper(TreeNode node) {
        if(node == null)
            return;
        this.helper(node.right);
        this.sum += node.val;
        node.val = this.sum;
        this.helper(node.left);
    }
}