package us.supercheng.algorithm.problems.algo.nodeswap;

public class Program {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Time: O(n) Space: O(1)
    public LinkedList nodeSwap(LinkedList head) {
        LinkedList ret = head;

        if (head != null && head.next != null)
            ret = head.next;

        for (LinkedList curr = head, leftOver = null; curr != null && curr.next != null; ) {
            LinkedList next = curr.next;

            if (leftOver != null)
                leftOver.next = next;
            leftOver = curr;

            LinkedList nextNext = next.next;
            next.next = curr;
            curr.next = nextNext;

            curr = nextNext;
        }

        return ret;
    }

    // Time: O(n) Space: O(n) [call stack]
    public LinkedList nodeSwapRec(LinkedList head) {
        if (head == null)
            return null;
        else if (head.next == null)
            return head;

        LinkedList next = head.next;
        LinkedList nextNext = next.next;

        head.next = this.nodeSwap(nextNext);
        next.next = head;

        return next;
    }
}
