package us.supercheng.algorithm.problems.leetcode.maximumnestingdepthoftheparentheses;

public class Solution {

    public int maxDepth(String s) {
        int ret = 0;

        for (int stack = 0, i=0, len = s.length(); i<len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack++;
                ret = Math.max(ret, stack);
            } else if (c == ')')
                stack--;
        }

        return ret;
    }
}