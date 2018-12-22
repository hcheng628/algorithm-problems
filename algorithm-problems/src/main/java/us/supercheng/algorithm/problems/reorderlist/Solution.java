package us.supercheng.algorithm.problems.reorderlist;

import us.supercheng.algorithm.common.entity.ListNode;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        if(head.next == null)
            return;

        List<ListNode> list = new ArrayList();
        for(;head != null;head = head.next)
            list.add(head);

        for(int start =0, end = list.size()-1;start < end;start++,end--) {
            ListNode nodeA = list.get(start);
            ListNode nodeB = list.get(end);
            nodeB.next = nodeA != null ? nodeA.next : null;
            nodeA.next = nodeB;
        }

        if(list.size() % 2 == 0)
            list.get(list.size()/2).next = null;
        else {
            ListNode mid = list.get(list.size()/2);
            list.get(list.size()/2).next = mid;
            mid.next = null;
        }
    }
}