package us.supercheng.algorithm.problems.lowestcommonancestorofabinarysearchtree;

import us.supercheng.algorithm.common.entity.TreeNode;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val ||
                (root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val))
            return root;

        return root.val > p.val && root.val > q.val ? this.lowestCommonAncestor(root.left, p, q) :
                this.lowestCommonAncestor(root.right, p, q);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        if (p.val > root.val && q.val > root.val)
            return this.lowestCommonAncestor2(root.right, p, q);
        else if (p.val < root.val && q.val < root.val)
            return this.lowestCommonAncestor2(root.left, p, q);
        else
            return root;
    }
}