package us.supercheng.algorithm.problems.algo.reversewordsinstring;

import java.util.*;

public class Program {

    public String reverseWordsInString(String string) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0, len=string.length(); i<len; i++) {
            char c = string.charAt(i);
            if (c == ' ') {
                if (sb.length() !=0) {
                    stack.push(sb.toString());
                    sb.setLength(0);
                }
                stack.push(" ");
            } else
                sb.append(c);
        }

        if (sb.length() > 0) {
            stack.push(sb.toString());
            sb.setLength(0);
        }

        while (!stack.isEmpty())
            sb.append(stack.pop());

        return sb.toString();
    }
}

