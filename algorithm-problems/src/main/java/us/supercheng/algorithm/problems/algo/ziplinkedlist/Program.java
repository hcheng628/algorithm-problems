package us.supercheng.algorithm.problems.algo.ziplinkedlist;

public class Program {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Time: O(n) Space: O(n)
    public LinkedList zipLinkedList(LinkedList linkedList) {
        LinkedList ret = linkedList;

        while (true) {
            Info res = this.helper(linkedList);

            if (res.next == null)
                break;

            LinkedList curr = res.curr;
            linkedList = res.next;

            if (curr.next != null)
                curr.next.next = linkedList;
        }

        return ret;
    }

    private Info helper(LinkedList list) {
        LinkedList ret = list;
        LinkedList prev = null;
        LinkedList next = ret.next;

        for (; list.next != null; list = list.next)
            prev = list;

        if (prev != null)
            prev.next = null;

        ret.next = list;

        if (list.next != null)
            list.next = null;

        return new Info(ret, next == null || next == list ? null : next);
    }

    class Info {
        LinkedList curr;
        LinkedList next;

        Info(LinkedList curr, LinkedList next) {
            this.curr = curr;
            this.next = next;
        }
    }
}