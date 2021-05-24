package us.supercheng.algorithm.problems.algo.longestbalancedsubstring;

import java.util.*;

public class Program {

    // Time: O(n^3) Space: O(1)
    public int longestBalancedSubstring_Solution1(String string) {
        int ret = 0;

        for (int i=0, len=string.length(); i<len; i++)
            for (int j=i+1; j<len; j++)
                ret = Math.max(this.balStr(string, i, j), ret);

        return ret * 2;
    }

    private int balStr(String s, int start, int end) {
        int count = 0;
        Stack<Character> stack = new Stack<>();

        for (; start<=end; start++)
            if (s.charAt(start) == '(') {
                stack.add('(');
                count++;
            } else {
                if (stack.isEmpty())
                    return 0;
                stack.pop();
            }

        return stack.isEmpty() ? count : 0;
    }

    // Time: O(n^2) Space: O(n)
    public int longestBalancedSubstring_Solution2(String string) {
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i=0, len=string.length(); i<len; i++) {
            char c = string.charAt(i);

            if (c == '(')
                stack.push(i);
            else {
                if (stack.isEmpty() || stack.peek() == -1)
                    stack.push(i);
                else {
                    if (string.charAt(stack.peek()) == '(') {
                        stack.pop();
                        if (!stack.isEmpty())
                            ret = Math.max(ret, i - stack.peek());
                    } else
                        stack.push(i);
                }
            }
        }

        return ret;
    }

    // Time: O(n) Space: O(1)
    public int longestBalancedSubstring(String string) {
        char[] chars = string.toCharArray();
        return Math.max(this.helper3(chars, true), this.helper3(chars, false));
    }

    private int helper3(char[] chars, boolean isForward) {
        int ret = 0;
        int len =chars.length;
        int openCount = 0;
        int closeCount = 0;

        if (isForward)
            for (int i=0; i<len; i++) {
                if (chars[i] == '(')
                    openCount++;
                else
                    closeCount++;
                if (openCount == closeCount)
                    ret = Math.max(openCount * 2, ret);
                else if (closeCount > openCount) {
                    openCount = 0;
                    closeCount = 0;
                }
            }
        else
            for (int i=len-1; i>-1; i--) {
                if (chars[i] == ')')
                    closeCount++;
                else
                    openCount++;
                if (closeCount == openCount)
                    ret = Math.max(closeCount * 2, ret);
                else if (openCount > closeCount) {
                    closeCount = 0;
                    openCount = 0;
                }
            }

        return ret;
    }

}
