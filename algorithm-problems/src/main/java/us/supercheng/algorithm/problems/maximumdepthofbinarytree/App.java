package us.supercheng.algorithm.problems.maximumdepthofbinarytree;

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
        if(t == null) {
            return count;
        }
        count++;
        int countA = goDown(t.left, count);
        int countB = goDown(t.right, count);
        return countA > countB ? countA : countB;
    }
}