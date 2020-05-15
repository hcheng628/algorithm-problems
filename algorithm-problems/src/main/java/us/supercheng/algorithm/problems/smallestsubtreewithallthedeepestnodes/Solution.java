package us.supercheng.algorithm.problems.smallestsubtreewithallthedeepestnodes;

import us.supercheng.algorithm.common.entity.TreeNode;

public class Solution {

    class Info {
        TreeNode n;
        int height;

        public Info(TreeNode n, int height) {
            this.n = n;
            this.height = height;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return this.dfs(root, 0).n;
    }

    private Info dfs(TreeNode root, int level) {
        if (root == null)
            return new Info(null, level);

        Info l = this.dfs(root.left, level + 1),
             r = this.dfs(root.right, level + 1);

        if (l.height == r.height)
            return new Info(root, l.height);
        else if (l.height > r.height)
            return l;
        else
            return r;
    }

    public TreeNode subtreeWithAllDeepestArr(TreeNode root) {
        return (TreeNode) this.dfsArr(root, 0)[1];
    }

    private Object[] dfsArr(TreeNode root, int level) {
        if (root == null)
            return new Object[]{level, null};

        Object[] l = this.dfsArr(root.left, level + 1),
                r = this.dfsArr(root.right, level + 1);

        if ((int) l[0] == (int) r[0])
            return new Object[]{l[0], root};
        else if ((int) l[0]  > (int) r[0])
            return l;
        else
            return r;
    }
}
