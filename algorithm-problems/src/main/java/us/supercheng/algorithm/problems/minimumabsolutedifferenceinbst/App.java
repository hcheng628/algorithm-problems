package us.supercheng.algorithm.problems.minimumabsolutedifferenceinbst;

import us.supercheng.algorithm.common.entity.TreeNode;
import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.ArrayList;
import java.util.Collections;

public class App {

    public static void main(String [] args) {
        PrintHelper.echoLn(new App().getMinimumDifference(null));
    }

    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        this.helper(root, list);
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<list.size() - 1;i++)
            min = Math.min(min, list.get(i+1) - list.get(i));
        return min;
    }

    private void helper(TreeNode node, ArrayList<Integer> list) {
        if(node == null)
            return;
        list.add(node.val);
        this.helper(node.left, list);
        this.helper(node.right, list);
    }
}