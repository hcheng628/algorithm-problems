package us.supercheng.algorithm.problems.leetcode.leafsimilartrees;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class App {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> listA = new ArrayList<>(), listB = new ArrayList<>();
        this.helper(root1, listA);
        this.helper(root2, listB);

        if(listA.size() != listB.size())
            return false;
        for(int i=0;i<listA.size();i++)
            if(listA.get(i) != listB.get(i))
                return false;
        return true;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if(root != null) {
            if(root.left == null && root.right == null) {
                list.add(root.val);
                return;
            }
            this.helper(root.right, list);
            this.helper(root.left, list);
        } else
            return;
    }
}