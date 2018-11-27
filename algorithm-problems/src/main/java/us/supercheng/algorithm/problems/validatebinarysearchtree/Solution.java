package us.supercheng.algorithm.problems.validatebinarysearchtree;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public boolean isValidBST(TreeNode root) {
        return root == null || this.helper(root, new ArrayList());
    }

    private boolean helper(TreeNode root, List<Integer> list) {
        if(root.left != null && (root.left.val >= root.val || !this.helper(root.left, list)))
            return false;

        list.add(root.val);

        return !(list.size() > 1 && list.get(list.size()-1) <= list.get(list.size()-2)) &&
                !(root.right != null && (root.right.val <= root.val || !this.helper(root.right, list)));
    }
}