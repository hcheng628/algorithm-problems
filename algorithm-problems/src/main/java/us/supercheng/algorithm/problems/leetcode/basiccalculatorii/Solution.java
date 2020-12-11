package us.supercheng.algorithm.problems.leetcode.basiccalculatorii;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;

        Stack<Integer> stack = new Stack();
        char[] chars = s.toCharArray();
        int num = 0;
        char operation = '+';

        for(int i=0;i<chars.length;i++) {
            char each = chars[i];
            if(Character.isDigit(each))
                num = (each - '0') + num * 10;
            if(i == chars.length - 1 || (!Character.isDigit(each) && each != ' ')) {
                if(operation == '+')
                    stack.push(num);
                else if (operation == '-')
                    stack.push(-num);
                else if (operation == '*')
                    stack.push(stack.pop() * num);
                else
                    stack.push(stack.pop() / num);
                operation = each;
                num = 0;
            }
        }

        while(!stack.isEmpty())
            num += stack.pop();
        return num;
    }
}