package us.supercheng.algorithm.problems.validparentheses;

import java.util.Stack;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        System.out.println(app.isValid("{[]}()"));
    }

    public boolean isValid(String s) {
        if(s.length() % 2 !=0) {
            return false;
        }
        Stack st = new Stack();
        for(int i=0;i<s.length();i++) {
            char each = s.charAt(i);
            if(st.size() != 0) {
                switch(each) {
                    case ')':
                        if(st.peek().toString().charAt(0) == '(') {
                            st.pop();
                        }
                        break;
                    case ']':
                        if(st.peek().toString().charAt(0) == '[') {
                            st.pop();
                        }
                        break;
                    case '}':
                        if(st.peek().toString().charAt(0) == '{') {
                            st.pop();
                        }
                        break;
                    default:
                        st.push(each);
                }
            } else {
                st.push(each);
            }
        }
        return st.size() > 0 ? false : true;
    }
}