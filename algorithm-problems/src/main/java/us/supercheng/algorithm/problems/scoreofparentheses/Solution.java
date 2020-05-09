package us.supercheng.algorithm.problems.scoreofparentheses;

import java.util.Stack;

class Solution {
    public int scoreOfParentheses(String S) {
        return this.helper(S.toCharArray(), 0, S.length()-1);
    }


    private int helper(char[] chars, int left, int right) {
        if (left + 1 == right)
            return 1;

        int balance = 0;
        for (int i=left; i<right;i++) {
            if (chars[i] == '(')
                balance++;
            else
                balance--;

            if (balance == 0)
                return this.helper(chars, left, i) + this.helper(chars, i+1, right);
        }

        return this.helper(chars, left+1, right-1) * 2;
    }

    public int scoreOfParenthesesRec(String S) {
        int ret = 0, len = S.length();

        for (int i=0; i<len; i++) {
            if (S.charAt(i) == ')')
                continue;

            int pos = i+1, count = 1;

            while (count != 0) {
                if (S.charAt(pos) == '(') {
                    count++;
                } else {
                    count--;
                }
                pos++;
            }

            int res = this.scoreOfParenthesesRec(S.substring(i+1, pos-1));
            ret += Math.max(2 * res, 1);
            i = pos -1;
        }

        return ret;
    }

    public int scoreOfParenthesesStack(String S) {
        int ret = 0;
        Stack<Integer> stack = new Stack();

        for (int i=0, len = S.length(); i<len; i++)
            if (S.charAt(i) == '(') {
                stack.push(ret);
                ret = 0;
            } else
                ret = stack.pop() + Math.max(ret*2, 1);

        return ret;
    }
}
