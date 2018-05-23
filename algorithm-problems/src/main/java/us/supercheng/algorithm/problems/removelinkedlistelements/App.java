package us.supercheng.algorithm.problems.removelinkedlistelements;

import us.supercheng.algorithm.common.entity.ListNode;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(6);

        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);
        ListNode g = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        int removeVal = 6;
        ListNode node =  app.removeElements(a,removeVal);
        while(node!= null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        ListNode saveHead = null;
        while(head != null && head.val == val) {
            head = head.next;
        }
        if(head == null) {
            return null;
        }
        saveHead = head;
        ListNode prev = head;
        head = head.next;
        while(head != null) {
            if(head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return saveHead;
    }
}