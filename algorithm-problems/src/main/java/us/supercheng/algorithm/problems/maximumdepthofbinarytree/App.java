package us.supercheng.algorithm.problems.maximumdepthofbinarytree;

import us.supercheng.algorithm.common.entity.TreeNode;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        System.out.println(app.maxDepth(null));
    }

    public int maxDepth(TreeNode root) {
        Integer count = 0;
        if(root == null) {
            return count;
        }
        count = goDown(root, count);
        return count;
    }

    public Integer goDown(TreeNode t, Integer count) {
        if(t == null)
            return count;

        count++;
        int countA = goDown(t.left, count);
        int countB = goDown(t.right, count);
        return countA > countB ? countA : countB;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;
    }
}