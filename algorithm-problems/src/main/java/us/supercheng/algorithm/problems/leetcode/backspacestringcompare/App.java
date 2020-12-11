package us.supercheng.algorithm.problems.leetcode.backspacestringcompare;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Stack;

public class App {

    public static void main(String[] args) {
        String S = "ab#c", T = "ad#c";
        PrintHelper.echoLn(new App().backspaceCompare(S, T));
        PrintHelper.echoLn(new App().backspaceCompare(S, T));
    }

    public boolean backspaceCompare(String S, String T) {
        return this.helper(S).equals(this.helper(T));
    }

    private String helper(String s) {
        while(s.indexOf("#") >=0) {
            int index = s.indexOf("#");
            if(index == 0)
                s = s.substring(1, s.length());
            else
                s = s.substring(0, index-1) + s.substring(index+1, s.length());
        }
        return s;
    }

    public boolean backspaceCompare1(String S, String T) {
        return this.helper1(S).equals(this.helper1(T));
    }

    private Stack helper1(String S) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<S.length();i++) {
            if(S.charAt(i) == '#') {
                if(!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(S.charAt(i));
        }
        return stack;
    }
}