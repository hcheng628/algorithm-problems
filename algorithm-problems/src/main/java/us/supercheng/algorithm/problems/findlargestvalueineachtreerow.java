package us.supercheng.algorithm.problems;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Integer max = null, len = queue.size();
            for (int i=0;i<len;i++) {
                TreeNode node = queue.remove();
                if (max == null || node.val > max)
                    max = node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            list.add(max);
        }

        return list;
    }
}