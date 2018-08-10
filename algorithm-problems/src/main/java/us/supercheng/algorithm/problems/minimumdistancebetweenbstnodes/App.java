package us.supercheng.algorithm.problems.minimumdistancebetweenbstnodes;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.helper(root, list);
        Collections.sort(list);
        int ret = Integer.MAX_VALUE;
        for(int i=list.size()-1;i>0;i--) {
            int res = list.get(i) - list.get(i-1);
            if(res < ret)
                ret = res;
        }
        return ret;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }
}
