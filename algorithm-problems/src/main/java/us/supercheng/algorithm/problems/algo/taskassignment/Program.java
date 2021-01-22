package us.supercheng.algorithm.problems.algo.taskassignment;

import java.util.*;

public class Program {

    // Time: O(nlog(n)) Space: O(n)
    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        int size = tasks.size();

        for (int i=0; i<size; i++) {
            int num = tasks.get(i);
            if (!map.containsKey(num))
                map.put(num, new Stack<>());
            map.get(num).push(i);
        }

        Collections.sort(tasks);
        for (int left=0, right=size-1; left<right; left++, right--)
            ret.add(new ArrayList<>(Arrays.asList(map.get(tasks.get(left)).pop(), map.get(tasks.get(right)).pop())));

        return ret;
    }

}
