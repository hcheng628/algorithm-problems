package us.supercheng.algorithm.problems.linkedlistcycle;

public class App {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.hasCycle(null);
    }

    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        while(head.next != null) {
            ListNode backUp = head;
            head = head.next;
            backUp.next = new ListNode(13);
        }
        if(head.val == 13) {
            return true;
        }
        return false;
    }
}