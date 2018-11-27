package us.supercheng.algorithm.problems.pathsumii;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList();
        this.helper(root, sum, ret, new ArrayList());
        return ret;
    }

    private void helper(TreeNode root, int curr, List<List<Integer>> ret, List<Integer> list) {
        if(root == null)
            return;
        int res = curr - root.val;
        list.add(root.val);
        if (res == 0 && root.left == null && root.right == null)
            ret.add(new ArrayList(list));
        else {
            this.helper(root.left, res, ret, list);
            this.helper(root.right, res, ret, list);
        }
        list.remove(list.size()-1);
    }
}
