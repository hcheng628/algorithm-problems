package us.supercheng.algorithm.problems.leetcode.binarytreelevelordertraversal;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList();
        if(root == null)
            return ret;

        Queue<TreeNode> queueParent = new LinkedList(),
                        queueChild = new LinkedList();

        queueParent.add(root);

        while(!queueParent.isEmpty() || !queueChild.isEmpty()) {
            List<Integer> list = new ArrayList();
            while(!queueParent.isEmpty()) {
                TreeNode node = queueParent.poll();
                list.add(node.val);
                if(node.left != null)
                    queueChild.add(node.left);
                if(node.right != null)
                    queueChild.add(node.right);
            }
            ret.add(list);
            Queue<TreeNode> temp = queueParent;
            queueParent = queueChild;
            queueChild = temp;
        }


        return ret;
    }
}