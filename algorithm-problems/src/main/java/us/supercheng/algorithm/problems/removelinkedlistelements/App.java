package us.supercheng.algorithm.problems.removelinkedlistelements;

import us.supercheng.algorithm.common.entity.ListNode;
import us.supercheng.algorithm.common.helper.PrintHelper;

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
        ListNode h = new ListNode(7);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;

        int removeVal = 6;
        int removeVal2 = 1;
        int removeVal3 = 4;

        PrintHelper.echoLn("removeElements removeVal: " + removeVal);

        ListNode node =  app.removeElements(a,removeVal);
        while(node!= null) {
            PrintHelper.echo(node.val + " ");
            node = node.next;
        }

        PrintHelper.echoLn("\nremoveElementsRecursion removeVal2: " + removeVal2);

        ListNode n = app.removeElementsRecursion(a, removeVal2);
        while(n!= null) {
            PrintHelper.echo(n.val + " ");
            n = n.next;
        }

        PrintHelper.echoLn("\nremoveElementsRecursion2 removeVal3: " + removeVal3);

        ListNode n2 = app.removeElementsRecursion2(a, removeVal3);
        while(n2!= null) {
            PrintHelper.echo(n2.val + " ");
            n2 = n2.next;
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

    public ListNode removeElementsRecursion(ListNode head, int val) {
        ListNode dummyHead = new ListNode(13);
        dummyHead.next = head;
        this.helperRecursion(dummyHead, val);
        return dummyHead.next;
    }

    public void helperRecursion(ListNode head, int val) {
        if(head == null || head.next == null)
            return;

        if(head.next.val == val)
            head.next = head.next.next;
        this.helperRecursion(head.next, val);
    }

    public ListNode removeElementsRecursion2(ListNode head, int val) {
        if(head == null)
            return null;
        head.next = this.removeElementsRecursion2(head.next, val);
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;

        if (head == null)
            return null;

        ListNode curr = head;

        while (curr != null && curr.next != null)
            if (curr.next.val == val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        return head;
    }

    public ListNode removeElements3(ListNode head, int val) {
        ListNode dummy = new ListNode(13),
                curr = dummy;
        dummy.next = head;

        while (curr.next != null)
            if (curr.next.val == val)
                curr.next = curr.next.next;
            else
                curr = curr.next;

        return dummy.next;
    }
}