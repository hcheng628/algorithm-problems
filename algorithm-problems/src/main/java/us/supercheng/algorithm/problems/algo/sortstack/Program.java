package us.supercheng.algorithm.problems.algo.sortstack;

import java.util.*;

public class Program {

    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        if (stack.isEmpty() || stack.size() == 1)
            return stack;

        int val = stack.remove(stack.size() - 1);
        this.sortStack(stack);

        if (stack.get(stack.size() - 1) > val) {
            int peekVal = stack.remove(stack.size() - 1);
            stack.add(val);
            this.sortStack(stack);
            stack.add(peekVal);
        } else
            stack.add(val);

        return stack;
    }
}
