package us.supercheng.algorithm.problems.middleofthelinkedlist;

import us.supercheng.algorithm.common.entity.ListNode;

public class App {

    int count = 0;
    ListNode ret = null;

    public ListNode middleNode(ListNode head) {
        if(head != null && head.next == null)
            return head;
        if(head != null && head.next != null && head.next.next == null)
            return head.next;
        if(head != null && head.next != null && head.next.next != null && head.next.next.next == null)
            return head.next;
        this.helper(head, 1);
        return ret;
    }

    private int helper(ListNode head, int currCount) {
        if(head == null)
            return this.count;
        int curr = this.helper(head.next, ++this.count);
        if(currCount == curr / 2 ) {
            ret = head;
            return -1;
        }
        return count;
    }
}
