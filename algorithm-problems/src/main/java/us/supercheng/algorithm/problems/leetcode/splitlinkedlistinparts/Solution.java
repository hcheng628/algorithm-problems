package us.supercheng.algorithm.problems.leetcode.splitlinkedlistinparts;

import us.supercheng.algorithm.common.entity.ListNode;

public class Solution {

    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null || k == 0)
            return new ListNode[k];

        ListNode curr = root;
        int total = 0;
        for (;curr != null;total++)
            curr = curr.next;

        ListNode[] ret = new ListNode[k];
        int width = total/k,
                extra = total%k;
        curr = root;

        for (int idx=0;curr!=null && idx<k;idx++) {
            ListNode prev = curr;
            boolean addExtra = extra > 0;
            ret[idx] = curr;
            for (int i=0;curr != null && i<width||addExtra;i++) {
                prev = curr;
                curr = curr.next;
                if (i==width) {
                    addExtra = false;
                    extra--;
                }
            }
            prev.next = null;
        }
        return ret;
    }
}