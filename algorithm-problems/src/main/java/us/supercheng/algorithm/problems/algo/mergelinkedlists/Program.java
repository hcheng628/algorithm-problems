package us.supercheng.algorithm.problems.algo.mergelinkedlists;

import java.util.*;

public class Program {

    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        if (headOne == null)
            return headTwo;
        else if (headTwo == null)
            return headOne;

        LinkedList ret = headOne.value < headTwo.value ? headOne : headTwo;
        LinkedList curr = null;

        while (headOne != null && headTwo != null) {
            if (headOne.value < headTwo.value) {
                if (curr != null)
                    curr.next = headOne;
                curr = headOne;
                headOne = headOne.next;
            } else {
                if (curr != null)
                    curr.next = headTwo;
                curr = headTwo;
                headTwo = headTwo.next;
            }
        }

        if (headOne != null)
            curr.next = headOne;

        if (headTwo != null)
            curr.next = headTwo;

        return ret;
    }
}
