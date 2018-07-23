package us.supercheng.algorithm.problems.secondminimumnodeinabinarytree;

import us.supercheng.algorithm.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

public class App {


    public int findSecondMinimumValue(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        this.helper(root, list);
        Collections.sort(list);
        return list.size() > 1 ? list.get(1) : -1;
    }

    private void helper(TreeNode root, ArrayList<Integer> list) {
        if(root == null)
            return;

        if(!list.contains(root.val))
            list.add(root.val);

        this.helper(root.left, list);
        this.helper(root.right, list);
    }



    int min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

    public int findSecondMinimumValue2(TreeNode root) {
        helper2(root);
        return min2 != Integer.MAX_VALUE ? min2 : -1;
    }

    private void helper2(TreeNode root) {
        if(root == null)
            return;
        if(root.val < min) {
            int temp = min;
            min = root.val;
            min2 = temp;
        } else if (root.val > min && root.val < min2)
            min2 = root.val;
        this.helper2(root.left);
        this.helper2(root.right);
    }


}