package us.supercheng.algorithm.problems.algo.linkedlistpalindrome;

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
    public boolean linkedListPalindrome(LinkedList head) {
        return this.helper(head, head).res;
    }

    private Info helper(LinkedList head, LinkedList curr) {
        if (curr == null)
            return new Info(null, true);

        if (curr.next == null)
            return new Info(head.next, head.value == curr.value);
        else {
            Info res = this.helper(head, curr.next);
            return res.res ? new Info(res.list.next, res.list.value == curr.value) : new Info(null, false);
        }
    }

    class Info {
        LinkedList list;
        boolean res;

        Info(LinkedList list, boolean res) {
            this.list = list;
            this.res = res;
        }
    }

}
