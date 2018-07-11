package us.supercheng.algorithm.problems.constructstringfrombinarytree;

import us.supercheng.algorithm.common.entity.TreeNode;

public class App {

    public String tree2str(TreeNode t) {
        return this.helper(t, "");
    }

    private String helper(TreeNode t, String str) {
        if(t == null)
            return str;
        if(t.left == null && t.right == null)
            return t.val + "";
        else if(t.left == null && t.right != null)
            return  t.val + "()(" + this.helper(t.right, "") + ")";
        else if(t.left != null && t.right == null)
            return t.val + "(" + this.helper(t.left, "") + ")";
        return  t.val + "(" + this.helper(t.left, t.val + "") + ")" + "(" + this.helper(t.right, t.val + "") + ")";
    }
}