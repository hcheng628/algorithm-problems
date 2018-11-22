package us.supercheng.algorithm.problems.rangesumofbst;

import us.supercheng.algorithm.common.entity.TreeNode;

public class App {
    private int ret = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        this.helper(root, L, R);
        return this.ret;
    }

    private void helper(TreeNode root, int L, int R) {
        if(root ==  null)
            return;
        if(root.val  >= L && root.val <= R)
            this.ret += root.val;
        this.helper(root.left, L, R);
        this.helper(root.right, L, R);
    }
}