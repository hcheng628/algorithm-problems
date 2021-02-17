package us.supercheng.algorithm.problems.algo.shiftlinkedlist;

public class Program {

    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        if (k == 0)
            return head;

        int count = 0;
        for (LinkedList curr=head; curr!=null; curr=curr.next)
            count++;

        if (count == 1)
            return head;

        k = k % count;

        if (k == 0)
            return head;
        else if (k < 0)
            k += count;

        LinkedList dummy = new LinkedList(-1);
        dummy.next = head;

        for (int i=0; i<count - k; i++)
            dummy = dummy.next;

        LinkedList ret = dummy.next;
        dummy.next = null;

        LinkedList tail = ret;
        while (tail != null && tail.next != null)
            tail = tail.next;

        if (tail != null)
            tail.next = head;

        return ret;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }

}
