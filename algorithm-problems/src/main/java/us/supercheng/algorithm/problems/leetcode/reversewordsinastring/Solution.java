package us.supercheng.algorithm.problems.leetcode.reversewordsinastring;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        String s =  "the    sk y i s blue ";
        Solution app = new Solution();
        PrintHelper.echoLn(app.reverseWords(s));
    }

    public String reverseWords(String s) {
        if(s == null || s.length() == 0)
            return "";
        String [] arr = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i=arr.length-1;i>-1;i--)
            if(arr[i].length() > 0)
                sb.append(i == 0 ? arr[i] : arr[i] + " ");
        return sb.toString();
    }

    public String reverseWords2(String s) {
        if(s == null || s.length() == 0)
            return "";

        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<chars.length;i++,sb.setLength(0)) {
            while(i<chars.length && !Character.isWhitespace(chars[i]) )
                sb.append(chars[i++]);
            if(sb.length() > 0)
                stack.push(sb.toString());
        }

        sb.setLength(0);
        int size = stack.size();
        for(int i=0;i<size;i++)
            sb.append(i == size -1 ? stack.pop() : stack.pop() + " ");

        return sb.toString();
    }
}