package us.supercheng.algorithm.problems.algo.findloop;

import java.util.HashSet;
import java.util.Set;

public class Program {

    public static LinkedList findLoop_Solution1(LinkedList head) {
        Set<LinkedList> visited = new HashSet<>();

        for (; head.next != null; head = head.next) {
            if (visited.contains(head))
                return head;
            visited.add(head);
        }

        return null;
    }

    public static LinkedList findLoop_Solution2(LinkedList head) {
        LinkedList slow = head;
        LinkedList fast = head;

        do {
            slow = slow.next;
            fast = fast.next.next;
        } while(slow != fast);

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}