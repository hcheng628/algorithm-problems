package us.supercheng.algorithm.problems.removeduplicatesfromsortedlistii;

import us.supercheng.algorithm.common.entity.ListNode;

public class App {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        ListNode ret = new App().deleteDuplicates(a);
        for(;ret != null;ret = ret.next)
            System.out.println(ret.val);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(head.val -1);
        dummyHead.next = head;
        ListNode prevNode = dummyHead;
        while(head!= null && head.next != null) {
            if(head.val == head.next.val) {
                while (head != null && head.next != null  && head.val == head.next.val)
                    head.next = head.next.next;
                prevNode.next = head.next;
            } else
                prevNode = head;
            head = head.next;
        }
        return dummyHead.next;
    }
}