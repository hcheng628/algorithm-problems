package us.supercheng.algorithm.problems.algo.removeduplicatesfromlinkedlist;

import java.util.*;

public class Program {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        for (LinkedList head = linkedList; head!= null; )
            if (head.next != null && head.value == head.next.value)
                head.next = head.next.next;
            else
                head = head.next;

        return linkedList;
    }
}

