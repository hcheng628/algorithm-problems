package us.supercheng.algorithm.problems.leetcode.insertionsortlist;

import us.supercheng.algorithm.common.entity.ListNode;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode curr = head,
                ret = null;

        while(curr != null) {
            ListNode popNode = curr;
            curr = curr.next;
            ret = this.helper(popNode, ret);
        }

        return ret;
    }

    private ListNode helper(ListNode node, ListNode ret) {
        if(ret == null) {
            ret = node;
            node.next = null;
            return ret;
        }

        ListNode dummy = ret,
                prev = null,
                backup = ret;


        for(;dummy != null;prev = dummy,dummy = dummy.next)
            if(node.val <= dummy.val) {
                if(prev == null) {
                    node.next = backup;
                    return node;
                }
                prev.next = node;
                node.next = dummy;
                return backup;
            }

        prev.next = node;
        node.next = null;
        return backup;
    }
}