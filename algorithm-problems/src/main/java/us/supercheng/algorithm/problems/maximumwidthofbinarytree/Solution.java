package us.supercheng.algorithm.problems.maximumwidthofbinarytree;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.HashMap;
import java.util.Map;

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
}