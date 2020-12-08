package us.supercheng.algorithm.problems.validatestacksequences;

import java.util.Stack;

public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        boolean[] set = new boolean[1000];
        int len = pushed.length,
                idx = 0;

        for (int p : pushed) {
            stack.push(p);
            set[p] = true;

            for (; !stack.isEmpty() && idx<len && stack.peek() == popped[idx]; idx++)
                stack.pop();

            if (idx < len && set[popped[idx]])
                return false;
        }

        return true;
    }
}
