package us.supercheng.algorithm.problems.sortlist;

import us.supercheng.algorithm.common.entity.ListNode;

class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = this.getMid(head);
        ListNode right = this.sortList(mid.next);
        mid.next = null;
        ListNode left = this.sortList(head);
        return this.merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(13),
                ret = dummy;

        for(;left != null && right != null;dummy = dummy.next,dummy.next = null) {
            if(left.val <= right.val) {
                dummy.next = left;
                left = left.next;
            } else {
                dummy.next = right;
                right = right.next;
            }
        }

        if(left != null)
            dummy.next = left;
        else
            dummy.next = right;

        return ret.next;
    }

    private ListNode getMid(ListNode head) {
        for(ListNode fast = head.next;fast!=null && fast.next != null;head = head.next,fast=fast.next.next);
        return head;
    }
}