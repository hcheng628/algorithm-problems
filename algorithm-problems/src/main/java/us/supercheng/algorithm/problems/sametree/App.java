package us.supercheng.algorithm.problems.sametree;

public class App {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }

    public static void main(String[]  args) {
        App app = new App();
        System.out.println(app.isSameTree(null, null));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            if(p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}