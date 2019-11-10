package us.supercheng.algorithm.problems.validparenthesisstring;

import java.util.Stack;

class Solution {

    private Boolean[][] mat;

    public boolean checkValidStringMemo(String s) {
        if (s == null || s.length() < 1)
            return true;

        int len = s.length();
        this.mat = new Boolean[len][len];
        return this.isValid(s, 0, len-1);
    }

    private boolean isValid(String s, int from, int to) {
        if (from > to)
            return true;

        if (this.mat[from][to] != null)
            return this.mat[from][to];

        if (from == to && s.charAt(from) == '*')
            return this.mat[from][to] = true;

        char left = s.charAt(from),
                right = s.charAt(to);
        if ((left == '*' || left == '(') &&
                (right == '*' || right == ')') &&
                this.isValid(s, from+1, to-1))
            return this.mat[from][to] = true;

        for (int i=from;i<to;i++)
            if (this.isValid(s, from, i) && this.isValid(s, i+1, to))
                return this.mat[from][to] = true;

        return this.mat[from][to] = false;
    }


    public boolean checkValidStringLTE(String s) {
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