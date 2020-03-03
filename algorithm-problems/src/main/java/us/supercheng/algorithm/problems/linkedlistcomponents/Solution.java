package us.supercheng.algorithm.problems.linkedlistcomponents;

import us.supercheng.algorithm.common.entity.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int g : G)
            set.add(g);

        int ret = 0;
        while (head != null)
            if (set.contains(head.val)) {
                ret++;
                while (head != null && set.contains(head.val))
                    head = head.next;
            } else
                head = head.next;

        return ret;
    }

    public int numComponentsRec(ListNode head, int[] G) {
        Set<Integer> visited = new HashSet<>(),
                set = new HashSet<>();

        Map<Integer, Integer> mapVal = new HashMap<>(),
                mapIdx = new HashMap<>();

        int ret = 0,
                idx = 0;

        for (;head != null;head = head.next,idx++) {
            mapIdx.put(idx, head.val);
            mapVal.put(head.val, idx);
        }

        for (int g : G)
            set.add(g);

        for (int i=0,len=G.length;i<len;i++)
            if (!visited.contains(G[i])) {
                this.travel(mapVal, mapIdx, visited, set, G[i], idx);
                ret++;
            }

        return ret;
    }

    private void travel(Map<Integer, Integer> mapVal, Map<Integer, Integer> mapIdx, Set<Integer> visited, Set<Integer> set, int val, int listLen) {
        visited.add(val);
        int idx = mapVal.get(val);

        for (int i=idx-1;i>-1 && set.contains(mapIdx.get(i));i--)
            visited.add(mapIdx.get(i));

        for (int i=idx+1;i<listLen && set.contains(mapIdx.get(i));i++)
            visited.add(mapIdx.get(i));
    }
}