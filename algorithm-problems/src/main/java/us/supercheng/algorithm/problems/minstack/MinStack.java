package us.supercheng.algorithm.problems.minstack;

import java.util.Iterator;
import java.util.Stack;

class MinStack {

    private final Stack<Integer> stack;
    private int min;
    private Iterator<Integer> iterator;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if(x < min) {
            min = x;
        }
    }

    public void pop() {
        int temp = stack.peek();
        stack.pop();
        if(temp <= this.min) {
            this.min = Integer.MAX_VALUE;
            this.iterator = stack.iterator();
            int each = Integer.MAX_VALUE;
            while(iterator.hasNext()) {
                each = iterator.next();
                if(each < this.min) {
                    this.min = each;
                }
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}