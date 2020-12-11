package us.supercheng.algorithm.problems.leetcode.decodestring;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        int rep = 0;
        StringBuilder ret = new StringBuilder();
        Stack<Integer> repStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        for (int i=0;i<s.length();i++) {
            char each = s.charAt(i);
            if (Character.isDigit(each)) {
                rep = each - '0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1)))
                    rep = (rep * 10) + (s.charAt(++i) - '0');
            } else if (each == '[') {
                repStack.push(rep);
                rep = 0;
                strStack.push(ret.toString());
                ret.setLength(0);
            } else if (each == ']') {
                StringBuilder sb = new StringBuilder(strStack.pop());
                int currRep = repStack.pop();
                for (int j=0;j<currRep;j++)
                    sb.append(ret);
                ret = sb;
            } else
                ret.append(each);
        }

        return ret.toString();
    }
}