package us.supercheng.algorithm.problems.taskscheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    public int leastInterval(char[] tasks, int n) {

        int[] todos = new int[26];
        int ret = 0;
        for (char task : tasks)
            todos[task - 'A']++;

        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());

        for (int todo : todos)
            if (todo > 0)
                queue.add(todo);

        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1)
                        temp.add(queue.poll()-1);
                    else
                        queue.poll();
                }
                ret++;
                if (queue.isEmpty() && temp.size() == 0)
                    break;
                i++;
            }
            for (int each : temp)
                queue.add(each);
        }

        return ret;
    }
}