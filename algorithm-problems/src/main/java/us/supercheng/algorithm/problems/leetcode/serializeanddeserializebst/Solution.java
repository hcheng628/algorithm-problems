package us.supercheng.algorithm.problems.leetcode.serializeanddeserializebst;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private String SPLITTER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        this.doSerialize(sb, root);
        return sb.toString();
    }

    private void doSerialize(StringBuilder sb, TreeNode root) {
        if (root == null)
            return;

        sb.append(root.val);
        sb.append(SPLITTER);

        this.doSerialize(sb, root.left);
        this.doSerialize(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() < 1)
            return null;

        Queue<Integer> queue = new LinkedList<>();

        for (String s: data.split(SPLITTER))
            queue.add(Integer.parseInt(s));

        return this.doDeserialize(queue);
    }

    private TreeNode doDeserialize(Queue<Integer> queue) {
        if (queue.isEmpty())
            return null;

        TreeNode head = new TreeNode(queue.remove());
        Queue<Integer> leftQueue = new LinkedList<>(),
                rightQueue = new LinkedList<>();

        while(!queue.isEmpty() && queue.peek() < head.val)
            leftQueue.add(queue.remove());
        while(!queue.isEmpty() && queue.peek() > head.val)
            rightQueue.add(queue.remove());

        head.left = this.doDeserialize(leftQueue);
        head.right = this.doDeserialize(rightQueue);

        return head;
    }
}