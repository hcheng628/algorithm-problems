package us.supercheng.algorithm.problems.leetcode.longestabsolutefilepath;

import java.util.Stack;

class Solution {

    public int lengthLongestPath(String input) {
        int maxLen = 0;

        if (input == null || input.length() < 1)
            return maxLen;

        Stack<Integer> stack = new Stack<>();
        String[] paths = input.split("\n");

        for (String path : paths) {
            int level = path.lastIndexOf("\t") + 1;

            while (level < stack.size())
                stack.pop();

            int currLen = stack.isEmpty() ? path.length() - level + 1
                    : stack.peek() + path.length() - level + 1;

            if (path.contains("."))
                maxLen = Math.max(maxLen, currLen - 1);
            stack.push(currLen);
        }

        return maxLen;
    }
}