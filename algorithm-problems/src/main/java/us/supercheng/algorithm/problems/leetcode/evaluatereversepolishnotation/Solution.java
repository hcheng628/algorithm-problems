package us.supercheng.algorithm.problems.leetcode.evaluatereversepolishnotation;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String each : tokens) {
            char c = each.charAt(0);
            if(each.length() == 1 && (c < 48 || c > 57))
                stack.push(this.doCal(c,stack.pop(), stack.pop()));
            else
                stack.push(Integer.parseInt(each));
        }
        return stack.pop();
    }

    private int doCal(char operator, int a, int b) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            default:
                return b / a;
        }
    }
}