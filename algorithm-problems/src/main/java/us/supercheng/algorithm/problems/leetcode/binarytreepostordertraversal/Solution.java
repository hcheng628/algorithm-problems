package us.supercheng.algorithm.problems.leetcode.binarytreepostordertraversal;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    private class Command{
        boolean go;
        TreeNode node;
        public Command(boolean go, TreeNode node) {
            this.go = go;
            this.node = node;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<Command> stack = new Stack<>();
        List<Integer> ret = new ArrayList<>();
        if (root == null)
            return ret;

        stack.add(new Command(true, root));
        while (!stack.isEmpty()) {
            Command cmd = stack.pop();
            if (cmd.go) {
                stack.add(new Command(false, cmd.node));
                if (cmd.node.right != null)
                    stack.add(new Command(true, cmd.node.right));
                if (cmd.node.left != null)
                    stack.add(new Command(true, cmd.node.left));
            } else
                ret.add(cmd.node.val);
        }
        return ret;
    }
}