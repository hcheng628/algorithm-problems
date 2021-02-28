package us.supercheng.algorithm.problems.algo.shortenpath;

import java.util.*;

public class Program {

    public static String shortenPath(String path) {
        boolean isAbs = path.charAt(0) == '/';
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (String p : path.split("/")) {
            if (p.equals(".") || p.equals("/") || p.length() == 0)
                continue;

            if (p.equals("..")) {
                if (isAbs) {
                    if (!stack.isEmpty())
                        stack.pop();
                } else {
                    if (!stack.isEmpty() && !stack.peek().equals(".."))
                        stack.pop();
                    else
                        stack.add(p);
                }
            } else
                stack.add(p);
        }

        if (isAbs && stack.isEmpty())
            return "/";

        while (!stack.isEmpty())
            sb.insert(0, "/" + stack.pop());

        return isAbs ? sb.toString() : sb.substring(1);
    }
}
