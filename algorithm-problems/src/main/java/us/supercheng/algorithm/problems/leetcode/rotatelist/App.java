package us.supercheng.algorithm.problems.leetcode.rotatelist;

import us.supercheng.algorithm.common.entity.ListNode;

public class App {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0)
            return head;
        ListNode fakeHead = new ListNode(13);
        fakeHead.next = head;
        ListNode temp = fakeHead;
        int len = 0;

        for(;temp.next!=null;len++)
            temp = temp.next;

        if (len <= k && len != 0)
            k = k % len;
        if(k == 0 || len == 1 || len == 0)
            return head;

        temp = fakeHead;
        for(int i=0;i<len-k;i++)
            temp = temp.next;

        fakeHead.next = temp.next;
        ListNode backup = temp;
        for(int i=0;i<k;i++)
            temp = temp.next;
        temp.next = head;
        backup.next = null;
        return fakeHead.next;
    }
}