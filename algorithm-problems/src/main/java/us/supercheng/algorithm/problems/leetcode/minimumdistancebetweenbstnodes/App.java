package us.supercheng.algorithm.problems.leetcode.minimumdistancebetweenbstnodes;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class App {

    public int minDiffInBST1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.helper1(root, list);
        int ret = Integer.MAX_VALUE;
        for(int i=list.size()-1;i>0;i--) {
            int res = list.get(i) - list.get(i-1);
            if(res < ret)
                ret = res;
        }
        return ret;
    }

    private void helper1(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        helper1(root.left, list);
        list.add(root.val);
        helper1(root.right, list);
    }


    Integer prev = null, ret = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        this.helper(root);
        return this.ret;
    }

    private void helper(TreeNode root) {
        if(root == null)
            return;
        helper(root.left);
        this.update(root.val);
        helper(root.right);
    }

    private void update(int newVal) {
        if(this.prev != null && this.ret > newVal - this.prev)
            this.ret = newVal - this.prev;
        this.prev = newVal;
    }
}