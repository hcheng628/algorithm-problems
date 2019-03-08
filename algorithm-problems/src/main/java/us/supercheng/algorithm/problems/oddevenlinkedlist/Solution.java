package us.supercheng.algorithm.problems.oddevenlinkedlist;

import us.supercheng.algorithm.common.entity.ListNode;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode odd = head, even = head.next, oddBak = odd, evenBak = even;
        while (odd != null && even != null) {

            odd.next = even.next;
            if (odd.next != null)
                even.next = odd.next.next;

            if (odd.next == null)
                odd.next = evenBak;
            else if (even.next == null)
                odd.next.next = evenBak;

            odd = odd.next;
            even = even.next;
        }
        return oddBak;
    }
}