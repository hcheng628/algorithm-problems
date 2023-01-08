package us.supercheng.algorithm.problems.leetcode.findacorrespondingnodeofabinarytreeinacloneofthattree;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(original);
        q2.offer(cloned);

        while ( !q1.isEmpty() ) {
            TreeNode curr = q1.poll();
            TreeNode currClone = q2.poll();

            if (curr == target)
                return currClone;

            if (curr.left != null) {
                q1.offer(curr.left);
                q2.offer(currClone.left);
            }

            if (curr.right != null) {
                q1.offer(curr.right);
                q2.offer(currClone.right);
            }
        }

        return null;    // should not get here!!!
    }

}
