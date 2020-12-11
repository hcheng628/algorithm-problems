package us.supercheng.algorithm.problems.leetcode.trimabinarysearchtree;

import us.supercheng.algorithm.common.entity.TreeNode;

public class App {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null)
            return null;

        if(root.val < L || root.val > R) {
            if(root.left == null && root.right == null)
                return null;
            else if(root.left != null && root.right == null)
                return this.trimBST(root.left, L, R);
            else if(root.left == null && root.right != null)
                return this.trimBST(root.right, L, R);
            else {
                TreeNode right = this.trimBST(root.right, L, R);
                return right != null ? right : this.trimBST(root.left, L, R);
            }
        }
        root.left = this.trimBST(root.left, L, R);
        root.right = this.trimBST(root.right, L, R);
        return root;
    }

    public TreeNode trimBST2(TreeNode root, int L, int R) {
        if(root == null)
            return root;

        if(root.val < L)
            return trimBST2(root.right, L, R);
        if(root.val > R)
            return trimBST2(root.left, L, R);

        root.left = trimBST2(root.left, L, R);
        root.right = trimBST2(root.right, L, R);

        return root;
    }


}