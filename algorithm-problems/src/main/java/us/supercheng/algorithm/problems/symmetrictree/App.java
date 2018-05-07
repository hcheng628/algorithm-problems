package us.supercheng.algorithm.problems.symmetrictree;

public class App {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[]  args) {
        App app = new App();
        System.out.println(app.isSymmetric(null));

    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return goThruNodes(root.left, root.right);
    }

    public boolean goThruNodes(TreeNode l, TreeNode r) {
        if(l == null && r == null) {
            return true;
        }
        if(l == null) {
            return false;
        }
        if(r == null) {
            return false;
        }
        if (l.val != r.val) {
            return false;
        }
        return goThruNodes(l.left, r.right) && goThruNodes(l.right, r.left);
    }
}