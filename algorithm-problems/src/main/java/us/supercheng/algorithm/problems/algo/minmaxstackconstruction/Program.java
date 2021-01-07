package us.supercheng.algorithm.problems.algo.minmaxstackconstruction;

import java.util.*;

public class Program {

    static class MinMaxStack {

        List<int[]> timeMachine = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        public int peek() {
            this.validateOperation();
            return this.stack.peek();
        }

        public int pop() {
            this.validateOperation();
            this.timeMachine.remove(this.size() - 1);
            return this.stack.pop();
        }

        public void push(Integer number) {
            int newMin = number;
            int newMax = number;

            if (this.isNotEmpty()) {
                int [] minMax = this.timeMachine.get(this.size() - 1);
                newMin = Math.min(number, minMax[0]);
                newMax = Math.max(number, minMax[1]);
            }

            this.stack.push(number);
            this.timeMachine.add(new int[]{newMin, newMax});
        }

        public int getMin() {
            this.validateOperation();
            return this.timeMachine.get(this.size() - 1)[0];
        }

        public int getMax() {
            this.validateOperation();
            return this.timeMachine.get(this.size() - 1)[1];
        }

        private int size() {
            return this.stack.size();
        }

        private boolean isEmpty() {
            return this.stack.isEmpty();
        }

        private boolean isNotEmpty() {
            return !this.isEmpty();
        }

        private void validateOperation() {
            if (this.isEmpty())
                throw new RuntimeException("Empty Min Max Stack");
        }

    }
}


