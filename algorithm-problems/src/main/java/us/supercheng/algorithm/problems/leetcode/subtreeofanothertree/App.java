package us.supercheng.algorithm.problems.leetcode.subtreeofanothertree;

import us.supercheng.algorithm.common.entity.TreeNode;

public class App {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s.val == t.val) {
            boolean rootCheck = this.helper(s, t);
            if(rootCheck)
                return true;
        }
        boolean left = s.left != null ? this.isSubtree(s.left,  t) : false;
        boolean right = s.right != null ? this.isSubtree(s.right,  t) : false;
        return left || right;
    }

    private boolean helper(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;
        else if ((s != null && t == null) || (s == null && t != null))
            return false;
        else {
            if(s.val != t.val)
                return false;
            else
                return this.helper(s.left, t.left) && this.helper(s.right, t.right);
        }
    }
}
