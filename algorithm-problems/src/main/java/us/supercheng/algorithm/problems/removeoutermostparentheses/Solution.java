package us.supercheng.algorithm.problems.removeoutermostparentheses;

import java.util.Stack;

class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char each : S.toCharArray())
            if (each == '(') {
                stack.push(each);
                if (stack.size() > 1)
                    sb.append(each);
            } else {
                stack.pop();
                if (stack.size() > 0)
                    sb.append(each);
            }

        return sb.toString();
    }
}