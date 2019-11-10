package us.supercheng.algorithm.problems.validparenthesisstring;

import java.util.Stack;

class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() < 1)
            return true;
        return this.helper(s, 0, s.length());
    }


    public boolean helper(String s, int idx, int len) {
        if (idx == len)
            return false;
        else if (idx == len -1)
            return this.isValid(s.toCharArray());
        if (s.charAt(idx) == '*') {
            return this.helper(s,idx+1,len) ||
                    this.helper(s.substring(0, idx) + "(" + s.substring(idx+1, len), idx+1, len) ||
                    this.helper(s.substring(0, idx) + ")" + s.substring(idx+1, len), idx+1, len);
        } else
            return this.helper(s, idx+1, len);
    }

    private boolean isValid(char[] chars) {
        Stack<Character> stack = new Stack<>();
        for (char c : chars)
            if (c != '*') {
                if (stack.isEmpty()) {
                    if (c == ')')
                        return false;
                    stack.push(c);
                } else
                    if (c == ')')
                        stack.pop();
                    else
                        stack.push(c);
            }

        return stack.size() == 0;
    }
}