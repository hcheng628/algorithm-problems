package us.supercheng.algorithm.problems.algo.rearrangelinkedlist;

public class Program {

    // Time: O(n) Space: O(1)
    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        LinkedList less = new LinkedList(-1);
        LinkedList lessHead = less;
        LinkedList equal = new LinkedList(-1);
        LinkedList euqalHead = equal;
        LinkedList more = new LinkedList(-1);
        LinkedList moreHead = more;

        for (LinkedList curr = head; curr != null; curr = curr.next) {
            int val = curr.value;
            if (val < k) {
                less.next = curr;
                less = less.next;
            } else if (val == k) {
                equal.next = curr;
                equal = equal.next;
            } else {
                more.next = curr;
                more = more.next;
            }
        }

        if (lessHead.next != null)
            less.next = null;
        if (euqalHead.next != null)
            equal.next = null;
        if (moreHead.next != null)
            more.next = null;

        if (lessHead.next != null) {
            if (euqalHead.next != null) {
                less.next = euqalHead.next;
                if (moreHead.next != null)
                    equal.next = moreHead.next;
            } else if (moreHead.next != null)
                less.next = moreHead.next;

            return lessHead.next;
        } else {
            if (euqalHead.next != null) {
                if (moreHead.next != null)
                    equal.next = moreHead.next;
                return euqalHead.next;
            } else if (moreHead.next != null)
                return moreHead.next;
        }

        return null;
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
