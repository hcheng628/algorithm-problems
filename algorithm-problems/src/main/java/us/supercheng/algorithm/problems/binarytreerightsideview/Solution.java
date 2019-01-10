package us.supercheng.algorithm.problems.binarytreerightsideview;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList();
        Queue<TreeNode> q = new LinkedList();

        if(root == null)
            return ret;
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode each = null;
            Queue<TreeNode> temp = new LinkedList();
            while(!q.isEmpty()) {
                each = q.poll();
                if(each.left != null)
                    temp.add(each.left);
                if(each.right != null)
                    temp.add(each.right);
            }
            ret.add(each.val);
            q = temp;
        }
        return ret;
    }
}