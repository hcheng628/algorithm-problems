package us.supercheng.algorithm.problems.binarytreetilt;

import us.supercheng.algorithm.common.entity.TreeNode;
import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Stack;

public class App {

    public static void main(String[] args) {
        PrintHelper.echoLn(new App().findTilt(null));
        PrintHelper.echoLn(new App().findTilt2(null));
        PrintHelper.echoLn(new App().findTilt3(null));
    }

    private int ret = 0;

    public int findTilt(TreeNode root) {
        if(root == null)
            return 0;
        this.findTilt(root.left);
        this.findTilt(root.right);
        ret += Math.abs( this.helper(root.left) - this.helper(root.right) );
        return ret;
    }

    private int helper(TreeNode node) {
        if(node == null)
            return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        int ret = 0;
        while(!stack.isEmpty()) {
            TreeNode n = stack.pop();
            ret += n.val;
            if(n.left != null)
                stack.push(n.left);
            if(n.right != null)
                stack.push(n.right);
        }
        return ret;
    }

    public int findTilt2(TreeNode root) {
        if(root == null)
            return 0;
        this.findTilt2(root.left);
        this.findTilt2(root.right);
        ret += Math.abs( this.helper2(root.left) - this.helper2(root.right));
        return ret;
    }

    private int helper2(TreeNode node) {
        if(node == null)
            return 0;
        int leftSum = this.helper2(node.left);
        int rightSum = this.helper2(node.right);
        return leftSum + rightSum + node.val;
    }

    public int findTilt3(TreeNode root) {
        if(root == null)
            return 0;
        this.helper3(root);
        return ret;
    }

    private int helper3(TreeNode node) {
        if(node == null)
            return 0;
        int leftSum = this.helper3(node.left);
        int rightSum = this.helper3(node.right);
        ret += Math.abs( leftSum - rightSum);
        return leftSum + rightSum + node.val;
    }
}