package us.supercheng.algorithm.problems.algo.removekthnodefromend;

import java.util.*;

class Program {

    public static void removeKthNodeFromEnd_Solution1(LinkedList head, int k) {
        LinkedList fast = head;
        LinkedList slow = head;

        for (int i=0; i<k; i++) {
            if (fast == null)
                throw new RuntimeException("Invalid Data");
            fast = fast.next;
        }

        if (fast == null) {
            head.value = head.next.value;
            head.next = head.next.next;
        } else {
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            LinkedList del = slow.next;
            slow.next = del.next;
            del.next = null;
        }
    }

    public static void removeKthNodeFromEnd_Solution2(LinkedList head, int k) {
        LinkedList dummy = new LinkedList(-1);
        dummy.next = head;
        helper(dummy, k);

        if (head.value != dummy.next.value)
            head.value = dummy.next.value;
        if (head.next != dummy.next.next)
            head.next = dummy.next.next;
    }

    private static int helper(LinkedList curr, int k) {
        if (curr == null)
            return 0;

        int res = helper(curr.next, k);
        if (res == k) {
            LinkedList del = curr.next;
            curr.next = del.next;
            del.next = null;
        }

        return res + 1;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
