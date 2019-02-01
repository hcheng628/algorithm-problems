package us.supercheng.algorithm.problems.lowestcommonancestorofabinarytree;

import us.supercheng.algorithm.common.entity.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val)
            return root;
        TreeNode left = this.lowestCommonAncestor(root.left, p, q),
                right = this.lowestCommonAncestor(root.right, p, q);
        return  left != null && right != null ? root : left != null ? left : right;
    }
}