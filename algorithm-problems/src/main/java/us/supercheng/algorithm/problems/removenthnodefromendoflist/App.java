package us.supercheng.algorithm.problems.removenthnodefromendoflist;

import us.supercheng.algorithm.common.entity.ListNode;

public class App {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        this.helper(dummyHead, n);
        return dummyHead.next;
    }

    private int helper(ListNode head, int n) {
        if(head == null)
            return 0;

        int ret = this.helper(head.next, n);
        if(ret == 0)
            return ++ret;
        ++ret;

        if(ret - 1 == n)
            head.next = head.next.next;
        return ret;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyHead = new ListNode(13);
        dummyHead.next = head;

        this.del(dummyHead, n);
        return dummyHead.next;
    }

    private int del(ListNode node, int n) {
        if (node.next == null)
            return 1;
        int count = this.del(node.next, n);
        if (count == -1)
            return -1;
        else if (count == n) {
            node.next = node.next.next;
            return -1;
        }
        return ++count;
    }
}