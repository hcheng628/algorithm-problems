package us.supercheng.algorithm.problems.increasingordersearchtree;

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
}
