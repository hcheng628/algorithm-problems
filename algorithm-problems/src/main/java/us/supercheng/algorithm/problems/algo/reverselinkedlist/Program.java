package us.supercheng.algorithm.problems.algo.reverselinkedlist;

public class Program {

    public static LinkedList reverseLinkedList(LinkedList head) {
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

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}

