package us.supercheng.algorithm.problems.partitionlist;

import us.supercheng.algorithm.common.entity.ListNode;

public class App {

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-13),
                big= new ListNode(13),
                dummySmall = small,
                dummyBig = big;

        for(;head != null;head = head.next) {
            ListNode temp = new ListNode(head.val);
            if(head.val < x) {
                small.next = temp;
                small = small.next;
            } else {
                big.next = temp;
                big = big.next;
            }
        }

        if(small!=null)
            small.next = dummyBig.next;

        return dummySmall.next;
    }

}