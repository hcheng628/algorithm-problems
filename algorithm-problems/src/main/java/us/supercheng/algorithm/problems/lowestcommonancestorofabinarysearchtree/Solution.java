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
}