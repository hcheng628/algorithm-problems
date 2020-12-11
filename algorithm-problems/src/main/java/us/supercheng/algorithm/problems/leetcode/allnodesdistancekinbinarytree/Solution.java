package us.supercheng.algorithm.problems.leetcode.allnodesdistancekinbinarytree;

import us.supercheng.algorithm.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    Map<Integer, Integer> map;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        this.map = new HashMap<>();
        List<Integer> ret = new ArrayList<>();

        this.dfs(root, target, K, 10000);

        for (Map.Entry<Integer, Integer> entry : this.map.entrySet())
            if (entry.getValue() == K)
                ret.add(entry.getKey());

        return ret;
    }

    private int dfs(TreeNode root, TreeNode target, int K, int curr) {
        if (root == null)
            return curr;

        int dis = curr;

        if (root == target) {
            this.map.put(root.val, 0);
            dis = 0;
        }

        int l = this.dfs(root.left, target, K, dis + 1),
                r = this.dfs(root.right, target, K, Math.min(dis, l) + 1);

        if (r < l)
            this.dfs(root.left, target, K, r+1);

        if (!this.map.containsKey(root.val) || this.map.get(root.val) > curr)
            this.map.put(root.val, Math.min(Math.min(l, r), dis));

        return this.map.get(root.val) + 1;
    }
}