package us.supercheng.algorithm.problems.leetcode.convertsortedlisttobinarysearchtree;

import us.supercheng.algorithm.common.entity.ListNode;
import us.supercheng.algorithm.common.entity.TreeNode;

public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        return this.makeTree(head, null);
    }

    private TreeNode makeTree(ListNode start, ListNode end) {
        if(start == end)
            return null;

        ListNode slow = start,
                fast = start;

        while(fast!= end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = this.makeTree(start, slow);
        root.right = this.makeTree(slow.next, end);
        return root;
    }
}