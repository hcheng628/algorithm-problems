package us.supercheng.algorithm.problems.searchinabinarysearchtree;

import us.supercheng.algorithm.common.entity.TreeNode;

public class App {

    TreeNode node = null;

    public TreeNode searchBST(TreeNode root, int val) {
        helper(root, val);
        return node;
    }

    private void helper(TreeNode root, int val) {
        if(root == null)
            return;
        if(root.val == val) {
            node = root;
            return;
        } else if(root.val > val)
            this.helper(root.left, val);
        else
            this.helper(root.right, val);
    }
}