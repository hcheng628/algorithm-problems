package us.supercheng.algorithm.problems.binarytreetilt;

import us.supercheng.algorithm.common.entity.TreeNode;
import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Stack;

public class App {

    public static void main(String[] args) {
        PrintHelper.echoLn(new App().findTilt(null));
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

}
