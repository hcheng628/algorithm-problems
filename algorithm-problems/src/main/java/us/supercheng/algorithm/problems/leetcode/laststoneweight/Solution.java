package us.supercheng.algorithm.problems.leetcode.laststoneweight;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution {

    public int lastStoneWeight(int[] stones) {
        List<Integer> list = Arrays.stream(stones).boxed().collect(Collectors.toList());
        Collections.sort(list);

        while (list.size() > 1) {
            int lastVal = list.remove(list.size() - 1);
            int lastVal2 = list.remove(list.size() - 1);

            if (lastVal != lastVal2) {
                list.add(lastVal - lastVal2);
                Collections.sort(list);
            }
        }

        return list.isEmpty() ? 0 : list.get(0);
    }

    public int lastStoneWeightPriorityQueue(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);

        for (int s : stones)
            q.offer(s);

        while (q.size() > 1)
            q.offer(q.poll() - q.poll());

        return q.peek();
    }
}
