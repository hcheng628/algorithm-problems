package us.supercheng.algorithm.problems.copylistwithrandompointer;

import us.supercheng.algorithm.common.entity.RandomListNode;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap();
        for(RandomListNode curr = head;curr != null;curr = curr.next) {
            map.put(curr, map.getOrDefault(curr, new RandomListNode(curr.label)));
            RandomListNode copy = map.get(curr);

            if(curr.next != null) {
                map.put(curr.next, map.getOrDefault(curr.next, new RandomListNode(curr.next.label)));
                copy.next = map.get(curr.next);
            }

            if(curr.random != null) {
                map.put(curr.random, map.getOrDefault(curr.random, new RandomListNode(curr.random.label)));
                copy.random = map.get(curr.random);
            }
        }
        return map.get(head);
    }
}