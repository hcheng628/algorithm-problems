package us.supercheng.algorithm.problems.maximumwidthofbinarytree;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {

    int ret = 0;

    public int widthOfBinaryTree(TreeNode root) {
        this.dfs(root, 1, 0, new HashMap<>(), new HashMap<>());
        return this.ret;
    }

    private void dfs(TreeNode root, int level, int idx, Map<Integer, Integer> leftMap, Map<Integer, Integer> rightMap) {
        if (root == null)
            return;

        leftMap.put(level, Math.min(leftMap.getOrDefault(level, idx), idx));
        rightMap.put(level, Math.max(rightMap.getOrDefault(level, idx), idx));

        int res = rightMap.get(level) - leftMap.get(level) + 1;
        if (res > this.ret)
            this.ret = res;

        this.dfs(root.left, level+1, idx*2 + 1, leftMap, rightMap);
        this.dfs(root.right, level+1, idx*2 + 2, leftMap, rightMap);
    }

    public int widthOfBinaryTreeBFS(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer>  list = new LinkedList<>();
        int ret = 1;
        queue.add(root);
        list.add(1);

        while (!queue.isEmpty()) {
            int size = queue.size(),
                    left = 0,
                    right = 0;

            for (int i=0;i<size;i++) {
                TreeNode node = queue.remove();
                int idx = list.remove();

                if (i == 0)
                    left = idx;

                if (i == size-1)
                    right = idx;

                if (node.left != null) {
                    queue.add(node.left);
                    list.add(idx*2);
                }

                if (node.right != null) {
                    queue.add(node.right);
                    list.add(idx*2+1);
                }
            }
            ret = Math.max(right - left + 1, ret);
        }
        return ret;
    }
}