package us.supercheng.algorithm.problems.leetcode.reverselinkedlistii;

import us.supercheng.algorithm.common.entity.ListNode;

public class App {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n)
            return head;

        ListNode dummy = new ListNode(13);
        dummy.next = head;
        ListNode curr = dummy, prev = dummy, next;
        int count = 0;
        ListNode [] arr = new ListNode[n-m+1];

        for(;count < m;curr = curr.next)
            if(++count == m)
                prev = curr;

        for(int i=0;i<arr.length;i++,curr = curr.next)
            arr[i] = curr;

        next = arr[arr.length-1].next;
        prev.next = arr[arr.length-1];
        arr[0].next = next;

        for(int i=arr.length-1;i>0;i--)
            arr[i].next = arr[i-1];

        return dummy.next;
    }
}
