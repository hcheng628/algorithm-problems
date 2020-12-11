package us.supercheng.algorithm.problems.leetcode.cousinsinbinarytree;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.*;

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            parentMap.put(root.val, null);
        }

        int level = 0;
        while (!queue.isEmpty()) {
            Queue<TreeNode> eachLevelQueue = new LinkedList<>();
            while (!queue.isEmpty())
                eachLevelQueue.add(queue.poll());
            Set<Integer> set = new HashSet<>();
            while (!eachLevelQueue.isEmpty()) {
                TreeNode node = eachLevelQueue.poll();
                set.add(node.val);
                if (node.left !=  null) {
                    queue.add(node.left);
                    parentMap.put(node.left.val, node);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    parentMap.put(node.right.val, node);
                }
            }
            if (level > 1 && set.contains(x) && set.contains(y) && parentMap.get(x) != parentMap.get(y))
                return true;
            level++;
        }
        return false;
    }
}