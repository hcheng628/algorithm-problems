package us.supercheng.algorithm.problems.leetcode.allpossiblefullbinarytrees;

import us.supercheng.algorithm.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<TreeNode> allPossibleFBT(int N) {
        if (N < 0 || N % 2 == 0)
            return new ArrayList<>();
        else if (N == 1)
            return Arrays.asList(new TreeNode(0));

        List<TreeNode> ret = new ArrayList<>();

        for (int i=1; i<N; i+=2)
            for (TreeNode left : this.allPossibleFBT(i))
                for (TreeNode right : this.allPossibleFBT(N - i - 1)) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }

        return ret;
    }
}