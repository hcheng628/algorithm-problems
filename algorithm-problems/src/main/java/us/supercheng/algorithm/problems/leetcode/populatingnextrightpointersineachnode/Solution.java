package us.supercheng.algorithm.problems.leetcode.populatingnextrightpointersineachnode;

import us.supercheng.algorithm.common.entity.TreeLinkNode;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public void connect(TreeLinkNode root) {
        if(root == null)
            return;

        Queue<TreeLinkNode> queue = new LinkedList();
        queue.add(root);
        root.next = null;

        TreeLinkNode prev = null;

        for(;!queue.isEmpty();prev = null) {
            Queue<TreeLinkNode> tempQueue = new LinkedList();
            while(!queue.isEmpty()) {
                TreeLinkNode node = queue.poll();
                if(prev != null)
                    prev.next = node;

                if(tempQueue.isEmpty())
                    node.next = null;

                if(node.left != null) {
                    tempQueue.add(node.left);
                    tempQueue.add(node.right);
                }
                prev = node;
            }
            queue = tempQueue;
        }
    }
}