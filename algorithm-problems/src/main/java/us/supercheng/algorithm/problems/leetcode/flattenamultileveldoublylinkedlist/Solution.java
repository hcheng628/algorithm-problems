package us.supercheng.algorithm.problems.leetcode.flattenamultileveldoublylinkedlist;

import us.supercheng.algorithm.common.entity.NodeV1;

class Solution {
    public NodeV1 flatten(NodeV1 head) {
        NodeV1 ret = head;
        for(;head != null;head = head.next)
            if (head.child != null) {
                NodeV1 temp = head.next,
                        childNode = head.child;
                head.next = head.child;
                head.child = null;
                childNode.prev = head;
                while (childNode.next != null)
                    childNode = childNode.next;
                childNode.next = temp;
                if (temp!=null)
                    temp.prev = childNode;
            }
        return ret;
    }
}