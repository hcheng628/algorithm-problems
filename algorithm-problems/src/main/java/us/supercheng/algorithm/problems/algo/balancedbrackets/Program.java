package us.supercheng.algorithm.problems.algo.balancedbrackets;

import java.util.Stack;

public class Program {

    public static boolean balancedBrackets(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray())
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty())
                    return false;

                char p = stack.peek();
                if ((p == '(' && c == ')') || (p == '[' && c == ']') || (p == '{' && c == '}'))
                    stack.pop();
                else
                    return false;
            } else if (c == '(' || c == '[' || c == '{')
                stack.push(c);

        return stack.isEmpty();
    }

}