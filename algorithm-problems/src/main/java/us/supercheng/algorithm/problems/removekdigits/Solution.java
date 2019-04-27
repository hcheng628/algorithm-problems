package us.supercheng.algorithm.problems.removekdigits;

import java.util.Stack;

public class Solution {

    public String removeKdigits(String num, int k) {
        if (k == 0)
            return num;
        else if (k == num.length())
            return "0";

        Stack<Character> stack = new Stack<>();

        for (int i=0;i<num.length();i++) {
            char each = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > each) {
                stack.pop();
                k--;
            }
            stack.push(each);
        }

        while (!stack.isEmpty() && k>0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.insert(0, stack.pop());

        return this.trimLeadingZero(sb.toString());
    }

    private String trimLeadingZero(String s) {
        int idx=0;
        for (;idx<s.length();idx++)
            if (s.charAt(idx) != '0')
                break;
        String ret = s.substring(idx);
        return ret.length() == 0 ? "0" : ret;
    }

    public String removeKdigits2(String num, int k) {
        if (k == 0)
            return num;
        else if (k == num.length())
            return "0";

        int stackSize =-1;
        Character[] stack = new Character [num.length()];

        for (int i=0;i<num.length();i++) {
            char each = num.charAt(i);
            while (stackSize > -1 && k > 0 && stack[stackSize] > each) {
                stackSize--;
                k--;
            }
            stack[++stackSize] = each;
        }

        while (stackSize > -1 && k>0) {
            stackSize--;
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (stackSize > -1)
            sb.insert(0, stack[stackSize--]);

        int idx = 0;
        for (;idx<sb.length();idx++)
            if (sb.charAt(idx) != '0')
                break;
        String ret = sb.substring(idx);

        return ret.length() == 0 ? "0" : ret;
    }
}