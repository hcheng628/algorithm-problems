package us.supercheng.algorithm.problems.leetcode.addtwonumbersii;

import us.supercheng.algorithm.common.entity.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        l1 = this.reverseList(l1);
        l2 = this.reverseList(l2);

        int overflow = 0;
        ListNode currNode = new ListNode(13),
                retNode = currNode;

        while (l1 != null || l2 != null) {
            int res = overflow;
            if (l1 != null)
                res += l1.val;
            if (l2 != null)
                res += l2.val;

            if (res > 9)
                overflow = 1;
            else
                overflow = 0;

            currNode.next = new ListNode(res%10);
            currNode = currNode.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        if (overflow != 0)
            currNode.next = new ListNode(overflow);

        return this.reverseList(retNode.next);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}