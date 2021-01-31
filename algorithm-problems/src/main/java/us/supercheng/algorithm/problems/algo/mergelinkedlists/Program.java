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

    public static LinkedList mergeLinkedLists_Solution1(LinkedList headOne, LinkedList headTwo) {
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

    public static LinkedList mergeLinkedLists_Solution2(LinkedList headOne, LinkedList headTwo) {
        if (headOne == null)
            return headTwo;
        else if (headTwo == null)
            return headOne;

        LinkedList one = headOne;
        LinkedList two = headTwo;
        LinkedList prev = null;

        while (one != null && two != null)
            if (one.value < two.value) {
                prev = one;
                one = one.next;
            } else {
                LinkedList next = two.next;
                two.next = one;
                if (prev != null)
                    prev.next = two;
                prev = two;
                two = next;
            }

        if (two != null)
            prev.next = two;

        return headOne.value < headTwo.value ? headOne : headTwo;
    }

    public static LinkedList mergeLinkedLists_Solution3(LinkedList headOne, LinkedList headTwo) {
        if (headOne == null)
            return headTwo;
        else if (headTwo == null)
            return headOne;

        helper(headOne, headTwo, null);
        return headOne.value < headTwo.value ? headOne : headTwo;
    }

    public static void helper(LinkedList one, LinkedList two, LinkedList prev) {
        if (two == null)
            return;
        else if (one == null) {
            if (prev != null)
                prev.next = two;
            return;
        }

        if (one.value < two.value)
            helper(one.next, two, one);
        else {
            LinkedList next = two.next;
            if (prev != null)
                prev.next = two;
            two.next = one;
            helper(one, next, two);
        }
    }
}
