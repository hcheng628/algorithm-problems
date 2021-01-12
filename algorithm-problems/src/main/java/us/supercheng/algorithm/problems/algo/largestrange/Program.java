package us.supercheng.algorithm.problems.algo.largestrange;

import java.util.*;

public class Program {

    // Time: O(nlog(n) Space: O(n)
    public static int[] largestRange(int[] array) {
        if (array == null || array.length < 1)
            return new int[0];
        if (array.length < 2)
            return new int[]{array[0], array[0]};

        Arrays.sort(array);
        int[] ret = new int[]{array[0], array[0]};
        Stack<Integer> stack = new Stack<>();
        stack.push(array[0]);

        for (int from = 0, to = 1, len = array.length; to < len; to++) {
            int top = stack.peek();
            if (array[to] == top + 1) {
                stack.push(array[to]);
                if (stack.size() > ret[1] - ret[0] + 1) {
                    ret[0] = array[from];
                    ret[1] = array[to];
                }
            } else if (array[to] != top) {
                from = to;
                stack = new Stack<>();
                stack.push(array[from]);
            }
        }

        return ret;
    }
}
