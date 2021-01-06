package us.supercheng.algorithm.problems.algo.sunsetviews;

import java.util.*;

public class Program {

    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        boolean isReverse = direction.equals("EAST");
        int len = buildings.length;
        int start = isReverse ? len - 1 : 0;
        int end = isReverse ? -1 : len;
        int inc = isReverse ? -1 : 1;
        Stack<Integer> stack = new Stack<>();

        for (int max = 0; (isReverse && start > end) || (!isReverse && start < end); start += inc)
            if (stack.isEmpty() || buildings[start] > max) {
                stack.push(start);
                max = buildings[start];
            }

        ArrayList<Integer> ret = new ArrayList<>(stack);
        if (isReverse)
            Collections.reverse(ret);

        return ret;
    }

}
