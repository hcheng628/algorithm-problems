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

    public String tree2str2(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        this.helper2(t, sb);
        return sb.toString();

    }

    private void helper2(TreeNode t, StringBuilder sb) {
        if(t == null)
            return;
        if(t.left != null && t.right != null) {
            sb.append(t.val + "(");
            this.helper2(t.left, sb);
            sb.append(")(");
            this.helper2(t.right, sb);
            sb.append(")");
        } else if (t.left == null && t.right != null) {
            sb.append(t.val + "()(");
            this.helper2(t.right, sb);
            sb.append(")");
        } else if (t.left != null && t.right == null) {
            sb.append(t.val + "(");
            this.helper2(t.left, sb);
            sb.append(")");
        } else {
            sb.append(t.val);
        }
    }
}