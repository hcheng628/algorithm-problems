package us.supercheng.algorithm.problems.leetcode.increasingordersearchtree;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class App {

    List<TreeNode> list = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        this.helper(root);
        for(int i=0;i<this.list.size();i++) {
            TreeNode eachNode = this.list.get(i);
            eachNode.left = null;
            if(i+1 <= this.list.size()-1)
                eachNode.right = this.list.get(i+1);
            if(i==this.list.size()-1)
                eachNode.right = null;
        }
        return this.list.get(0);
    }

    private void helper(TreeNode node) {
        if(node == null)
            return;
        this.helper(node.left);
        this.list.add(node);
        this.helper(node.right);
    }


    // Approach 2

    TreeNode fakeHead;

    public TreeNode increasingBST1(TreeNode root) {
        this.fakeHead = new TreeNode(-13);
        TreeNode ret = this.fakeHead;
        this.helper1(root);
        return ret.right;
    }

    private void helper1(TreeNode node) {
        if(node == null)
            return;
        this.helper1(node.left);
        this.fakeHead.right = new TreeNode(node.val);;
        this.fakeHead = this.fakeHead.right;
        this.helper1(node.right);
    }
}
