package us.supercheng.algorithm.problems.leetcode.maximumdepthofnarytree;

import java.util.List;

public class Solution {

    int res;

    public int maxDepth(Node root) {
        this.res = 0;
        this.dfs(root, 0);
        return res;
    }

    private void dfs(Node root, int level) {
        if (root == null)
            return;

        int nextLevel = level + 1;
        if (nextLevel > res)
            this.res = nextLevel;

        for (Node c : root.children)
            this.dfs(c, nextLevel);
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}