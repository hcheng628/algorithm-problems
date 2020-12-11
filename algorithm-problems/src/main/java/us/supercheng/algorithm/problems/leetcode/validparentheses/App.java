package us.supercheng.algorithm.problems.leetcode.validparentheses;

import java.util.Stack;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        System.out.println(app.isValid("{[]}()"));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        else if(s.length() % 2 !=0)
            return false;

        Stack<Character> st = new Stack();

        for(char each : s.toCharArray())
            if(st.isEmpty())
                st.push(each);
            else
                switch(each) {
                    case ')':
                        if(st.peek()== '(')
                            st.pop();
                        break;
                    case ']':
                        if(st.peek() == '[')
                            st.pop();
                        break;
                    case '}':
                        if(st.peek() == '{')
                            st.pop();
                        break;
                    default:
                        st.push(each);
                }

        return st.isEmpty();
    }

    public boolean isValid2(String s) {
        if (s == null || s.length() == 0)
            return true;
        else if (s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();

        for (char each : s.toCharArray()) {
            if (each == '(' || each == '{' || each == '[')
                stack.push(each);
            else {
                if (stack.isEmpty())
                    return false;
                char peek = stack.peek();
                if ((peek == '(' && each == ')') || (peek == '{' && each == '}') || (peek == '[' && each == ']'))
                    stack.pop();
                else
                    return false;
            }
        }

        return stack.isEmpty();
    }
}