package us.supercheng.algorithm.problems.sumroottoleafnumbers;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;
        List<String> list = new ArrayList();

        if(root.left != null)
            this.helper(root.left, list, root.val+"");

        if(root.right != null)
            this.helper(root.right, list, root.val+"");

        int ret = 0;
        for(String each : list)
            ret += Integer.parseInt(each);
        return ret;
    }

    public void helper(TreeNode root, List<String> list, String s) {
        if(root.left != null && root.right != null) {
            this.helper(root.left, list, s + root.val);
            this.helper(root.right, list, s + root.val);
        } else if (root.left != null)
            this.helper(root.left, list, s + root.val);
        else if (root.right != null)
            this.helper(root.right, list, s + root.val);
        else
            list.add(s+ root.val);
    }
}