package us.supercheng.algorithm.problems.trimabinarysearchtree;

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
}