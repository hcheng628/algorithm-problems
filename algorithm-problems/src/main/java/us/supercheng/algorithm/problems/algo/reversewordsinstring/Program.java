package us.supercheng.algorithm.problems.algo.reversewordsinstring;

import java.util.*;

public class Program {

    public String reverseWordsInString_Solution1(String string) {
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

    public String reverseWordsInString(String string) {
        int len = string.length();
        char[] chars = string.toCharArray();
        reverse(chars, 0, len - 1);

        for (int i=0; i<len; ) {
            if (chars[i] == ' ')
                i++;
            else {
                int wordEnd = i + 1;
                while (wordEnd < len && chars[wordEnd] != ' ')
                    wordEnd++;

                reverse(chars, i, wordEnd - 1);
                i = wordEnd;
            }
        }

        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int from, int to) {
        for (; from < to; from++, to--)
            if (chars[from] != chars[to]) {
                char temp = chars[from];
                chars[from] = chars[to];
                chars[to] = temp;
            }
    }
}

