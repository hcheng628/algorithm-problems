package us.supercheng.algorithm.problems.leetcode.pathsumiii;

import us.supercheng.algorithm.common.entity.TreeNode;

public class App {

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.pathSum(null, 0));
    }

    private int count = 0;

    public int pathSum(TreeNode root, int sum) {
        this.visitAll(root, sum, sum);
        return this.count;
    }

    private void visitAll(TreeNode node, int sum, int target) {
        if(node == null)
            return;
        this.cal(node, sum, target);
        this.visitAll(node.left, sum, target);
        this.visitAll(node.right,sum, target);
    }

    private void cal(TreeNode node, int sum, int target) {
        if(node == null)
            return;
        int curSum = sum - node.val;
        if(curSum == 0) {
            this.count++;
            this.cal(node.left, curSum, target);
            this.cal(node.right, curSum, target);
        } else {
            this.cal(node.left, curSum, target);
            this.cal(node.right, curSum, target);
        }
    }

    public int pathSum2(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return this.dfs(root, sum) + this.pathSum2(root.left, sum) + this.pathSum2(root.right, sum);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int newVal = sum - root.val;
        return newVal == 0 ? this.dfs(root.left, newVal) + this.dfs(root.right, newVal) + 1
                : this.dfs(root.left, newVal) + this.dfs(root.right, newVal);
    }
}