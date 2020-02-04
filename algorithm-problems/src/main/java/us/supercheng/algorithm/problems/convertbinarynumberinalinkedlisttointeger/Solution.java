package us.supercheng.algorithm.problems.convertbinarynumberinalinkedlisttointeger;

import us.supercheng.algorithm.common.entity.ListNode;

public class Solution {

    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();

        for (;head != null;head = head.next)
            sb.append(head.val);

        int ret = 0;
        for (int i=sb.length()-1, pow = 0;i>-1;i--)
            ret += (sb.charAt(i) == '0' ? 0 : 1) * (int) Math.pow(2, pow++);

        return ret;
    }

    public int getDecimalValueBIT(ListNode head) {
        int ret = 0;

        for (;head != null; head=head.next)
            ret = (ret << 1) + head.val;

        return ret ^ 0;
    }
}