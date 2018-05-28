package us.supercheng.algorithm.problems.binarytreelevelordertraversalii;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        System.out.println(app.levelOrderBottom(null));
        System.out.println(app.levelOrderBottom2(null));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        helper(root, list, 0);
        List<List<Integer>> returnList = new ArrayList<>();
        for(int i=list.size()-1; i>=0;i--) {
            returnList.add(list.get(i));
        }
        return returnList;
    }

    public void helper(TreeNode root, List<List<Integer>> list, Integer level) {
        if(root == null) {
            return;
        }
        if(level >= list.size()) {
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(root.val);
        helper(root.left, list, level + 1);
        helper(root.right, list, level + 1);
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        if(root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0) {
            List<Integer> rowList = new ArrayList<>();
            int size = q.size();
            for (int i=0;i<size;i++) {
                TreeNode tree = q.poll();
                rowList.add(tree.val);
                if(tree.left != null) {
                    q.add(tree.left);
                }
                if(tree.right != null) {
                    q.add(tree.right);
                }
            }
            list.add(0,rowList);
        }
        return list;
    }
}