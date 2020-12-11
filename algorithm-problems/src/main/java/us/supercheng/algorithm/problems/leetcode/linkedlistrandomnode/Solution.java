package us.supercheng.algorithm.problems.leetcode.linkedlistrandomnode;

import us.supercheng.algorithm.common.entity.ListNode;
import java.util.Random;

class Solution {

    ListNode dummyHead;
    int length;
    Random random;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.random = new Random();
        dummyHead = new ListNode(13);
        dummyHead.next = head;

        for (ListNode curr = head;curr != null; curr = curr.next)
            this.length++;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        if (this.length == 0)
            throw new RuntimeException("Empty list nothing to return");

        ListNode curr = this.dummyHead.next;
        for (int i=0, randIdx = this.random.nextInt(length);i<randIdx;i++)
            curr = curr.next;

        return curr.val;
    }
}