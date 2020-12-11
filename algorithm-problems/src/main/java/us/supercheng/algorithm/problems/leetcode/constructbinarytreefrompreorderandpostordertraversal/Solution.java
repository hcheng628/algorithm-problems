package us.supercheng.algorithm.problems.leetcode.constructbinarytreefrompreorderandpostordertraversal;

import us.supercheng.algorithm.common.entity.TreeNode;

public class Solution {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int len = pre.length;
        int[][] idxMap = new int[2][len+1];

        for (int i=0; i<len; i++) {
            idxMap[0][pre[i]] = i;
            idxMap[1][post[i]] = i;
        }

        return this.helper(idxMap, pre, post, 0, len -1);
    }

    private TreeNode helper(int[][] idxMap, int[] pre, int[] post, int from, int to) {
        if (from > to || from >= pre.length || from < 0 || to >= pre.length || to < 0)
            return null;
        else if (from == to)
            return new TreeNode(pre[from]);

        TreeNode root = new TreeNode(pre[from]);

        int start = from + 1;
        if (start >= pre.length)
            return null;

        int postTo = idxMap[1][pre[from]] - 1;
        if (postTo < 0)
            return null;

        int count = idxMap[0][post[postTo]] - start - 1;

        root.left = this.helper(idxMap, pre, post, start, start + count);
        root.right = this.helper(idxMap, pre, post, start + count + 1, to);

        return root;
    }
}
