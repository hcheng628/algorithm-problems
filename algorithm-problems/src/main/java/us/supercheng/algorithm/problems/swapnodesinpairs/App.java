package us.supercheng.algorithm.problems.swapnodesinpairs;

import us.supercheng.algorithm.common.entity.ListNode;

public class App {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(13);  // my fav num because Steve Nash
        dummyHead.next = head;
        for(boolean swapFlag=false;dummyHead.next != null;dummyHead = dummyHead.next,swapFlag = !swapFlag) {
            if(swapFlag) {
                int backup = dummyHead.val;
                dummyHead.val = dummyHead.next.val;
                dummyHead.next.val = backup;
            }
        }
        return head;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(13),
                retNode = dummyHead;
        dummyHead.next = head;

        while (dummyHead.next != null && dummyHead.next.next != null) {
            ListNode first = dummyHead.next,
                    second = first.next;

            dummyHead.next = second;
            first.next = second.next;	// third
            second.next = first;

            dummyHead = dummyHead.next.next;
        }

        return retNode.next;
    }
}
