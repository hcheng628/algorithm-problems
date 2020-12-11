package us.supercheng.algorithm.problems.leetcode.printbinarytree;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> printTree(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        int rows = this.getHeight(root, 0),
                cols = getCols(rows);
        List<List<String>> ret = new ArrayList<>();

        for (int i=0;i<rows;i++) {
            List<String> row = new ArrayList<>();
            for (int j=0;j<cols;j++)
                row.add("");
            ret.add(row);
        }
        this.print(ret, root, 0, 0, cols);
        return ret;
    }

    private void print(List<List<String>> list, TreeNode root, int level, int left, int right) {
        if (root == null)
            return;
        int mid = (left+right)/2;
        list.get(level).set(mid, root.val + "");
        this.print(list, root.left, level+1, left, mid-1);
        this.print(list, root.right, level+1, mid+1, right);
    }

    private int getHeight(TreeNode root, int level) {
        return root == null ? level : Math.max(this.getHeight(root.left, level+1), this.getHeight(root.right, level+1));
    }

    private int getCols(int num) {
        return num == 1 ? num : this.getCols(num-1) * 2 + 1;
    }
}