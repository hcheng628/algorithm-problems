package us.supercheng.algorithm.problems.minimumdepthofbinarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

    public static void main(String[]  args) {
        App app = new App();
        System.out.println(Integer.MAX_VALUE);
        app.minDepthA(null);
        app.minDepthB(null);
    }

    public int minDepthA(TreeNode root) {
        if(root == null) {
            return 0;
        }
        List<Integer> intList = new ArrayList<>();
        helperA(root, 1, intList);
        Collections.sort(intList);
        return intList.get(0);
    }

    public void helperA(TreeNode root, int level, List<Integer> list) {
        if(root == null) {
            return;
        }
        if(root.left == root.right) {
            list.add(level);
        }
        helperA(root.left, level + 1, list);
        helperA(root.right,  level  + 1, list);
    }

    public int minDepthB(TreeNode root) {
        if(root == null ){
            return 0;
        }
        return helperB(root, 1);
    }

    public int helperB(TreeNode root, int level) {
        if(root.left == null && root.right == null) {
            return level;
        } else if (root.left != null && root.right ==null) {
            return helperB(root.left, level + 1);
        } else if (root.left == null && root.right != null) {
            return helperB(root.right, level + 1);
        } else {
            return Math.min(helperB(root.left, level + 1), helperB(root.right, level + 1));
        }
    }
}