package us.supercheng.algorithm.problems.binarytreepruning;

import us.supercheng.algorithm.common.entity.TreeNode;

public class Solution {

    public TreeNode pruneTree(TreeNode root) {
        this.helper(root);
        return root;
    }

    private boolean helper(TreeNode root) {
        if (root == null)
            return false;

        boolean ret = false;

        if (root.left != null)
            if (!this.helper(root.left))
                root.left = null;
            else
                ret = true;

        if (root.right != null)
            if (!this.helper(root.right))
                root.right = null;
            else if (!ret)
                ret = true;

        return ret || root.val == 1;
    }
}