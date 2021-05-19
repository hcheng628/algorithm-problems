package us.supercheng.algorithm.problems.algo.longestbalancedsubstring;

import java.util.*;

public class Program {

    // Time: O(n^3) Space: O(1)
    public int longestBalancedSubstring(String string) {
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

}
