package us.supercheng.algorithm.problems.leetcode.mergetwobinarytrees;

import us.supercheng.algorithm.common.entity.TreeNode;

public class App {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return this.helper(t1, t2);
    }

    private TreeNode helper(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return null;
        else if(t1 == null && t2 != null)
            return t2;
        else if(t1 != null && t2 == null)
            return t1;
        else {
            t1.val = t1.val + t2.val;
            t1.left = this.helper(t1.left, t2.left);
            t1.right = this.helper(t1.right, t2.right);
            return t2;
        }
    }
}