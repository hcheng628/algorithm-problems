package us.supercheng.algorithm.problems.binarytreezigzaglevelordertraversal;

import us.supercheng.algorithm.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList();
        if(root == null)
            return ret;

        Queue<TreeNode> queueParent = new LinkedList(),
                queueChild = new LinkedList();
        queueParent.add(root);

        boolean leftToRight = true;
        while(!queueParent.isEmpty() || !queueChild.isEmpty()) {
            List<Integer> list = new ArrayList();
            while(!queueParent.isEmpty()) {
                TreeNode node = queueParent.poll();
                if(leftToRight)
                    list.add(node.val);
                else
                    list.add(0, node.val);

                if(node.left != null)
                    queueChild.add(node.left);
                if(node.right != null)
                    queueChild.add(node.right);
            }
            ret.add(list);
            leftToRight = !leftToRight;
            Queue<TreeNode> temp = queueParent;
            queueParent = queueChild;
            queueChild = temp;
        }
        return ret;
    }
}
