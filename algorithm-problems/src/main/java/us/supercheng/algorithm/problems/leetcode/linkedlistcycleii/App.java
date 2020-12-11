package us.supercheng.algorithm.problems.leetcode.linkedlistcycleii;

import us.supercheng.algorithm.common.entity.ListNode;
import java.util.HashSet;
import java.util.Set;

public class App {

    public ListNode detectCycleSlow(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        for(;head != null;head = head.next) {
            if(set.contains(head))
                return head;
            else
                set.add(head);
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }

        if(fast == null || fast.next == null)
            return null;

        while(head != fast) {
            head = head.next;
            fast = fast.next;
        }
        return fast;
    }
}
