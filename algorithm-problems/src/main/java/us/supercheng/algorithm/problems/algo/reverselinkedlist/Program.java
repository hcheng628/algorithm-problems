package us.supercheng.algorithm.problems.algo.reverselinkedlist;

public class Program {

    public static LinkedList reverseLinkedList_Solution1(LinkedList head) {
        if (head == null)
            return head;

        LinkedList ret = head;
        LinkedList next = ret.next;
        ret.next = null;

        while (next != null) {
            LinkedList temp = next;
            next = next.next;
            temp.next = ret;
            ret = temp;
        }

        return ret;
    }

    public static LinkedList reverseLinkedList_Solution2(LinkedList head) {
        if (head == null || head.next == null)
            return head;

        LinkedList newHead = reverseLinkedList_Solution2(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static LinkedList reverseLinkedList_Solution3(LinkedList head) {
        LinkedList prev = null;

        for (LinkedList curr = head; curr != null; ) {
            LinkedList next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}

