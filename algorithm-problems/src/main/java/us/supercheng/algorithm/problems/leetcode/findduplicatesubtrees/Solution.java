package us.supercheng.algorithm.problems.leetcode.findduplicatesubtrees;

import us.supercheng.algorithm.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> ret = new ArrayList<>();

        this.travelse(root, map);
        for (String key : map.keySet()) {
            List<TreeNode> temp = map.get(key);
            if (temp.size() > 1)
                ret.add(temp.get(0));
        }
        return ret;
    }


    private void travelse(TreeNode root, Map<String, List<TreeNode>> map) {
        if (root == null)
            return;

        String s = this.helper(root);
        if (map.containsKey(s))
            map.get(s).add(root);
        else {
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            map.put(s, list);
        }

        this.travelse(root.left, map);
        this.travelse(root.right, map);
    }

    private String helper(TreeNode root) {
        if (root == null)
            return "#";
        return root.val + this.helper(root.left) + "," + this.helper(root.right);
    }

    public List<TreeNode> findDuplicateSubtreesPostOrder(TreeNode root) {
        List<TreeNode> ret = new ArrayList<>();
        this.postOrder(root, new HashMap<>(), ret);
        return ret;
    }

    private String postOrder(TreeNode root, Map<String, Integer> map, List<TreeNode> ret) {
        if (root == null) return "#";
        String s = root.val + "," + this.postOrder(root.left, map, ret) + "," + this.postOrder(root.right, map, ret);
        map.put(s, map.getOrDefault(s, 0)+1);
        if (map.get(s) == 2)
            ret.add(root);
        return s;
    }
}