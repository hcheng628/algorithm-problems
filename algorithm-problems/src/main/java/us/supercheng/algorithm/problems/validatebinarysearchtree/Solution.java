package us.supercheng.algorithm.problems.validatebinarysearchtree;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public boolean isValidBST1(TreeNode root) {
        return root == null || this.helper(root, new ArrayList());
    }

    private boolean helper(TreeNode root, List<Integer> list) {
        if(root.left != null && (root.left.val >= root.val || !this.helper(root.left, list)))
            return false;

        list.add(root.val);

        return !(list.size() > 1 && list.get(list.size()-1) <= list.get(list.size()-2)) &&
                !(root.right != null && (root.right.val <= root.val || !this.helper(root.right, list)));
    }

    public boolean isValidBST(TreeNode root) {
        return this.helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long MIN, long MAX) {
        if (root == null)
            return true;
        else if (root.val < MIN || root.val > MAX)
            return false;
        return this.helper(root.left, MIN,  ((long) root.val) - 1) &&
                this.helper(root.right, ((long) root.val) + 1, MAX);
    }
}