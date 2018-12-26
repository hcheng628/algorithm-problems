package us.supercheng.algorithm.problems.binarytreepreordertraversal;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null)
            return ret;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode n = stack.pop();
            if(n != null) {
                ret.add(n.val);
                if(n.right != null)
                    stack.push(n.right);
                if(n.left != null)
                    stack.push(n.left);
            }
        }

        return ret;
    }
}