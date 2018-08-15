package us.supercheng.algorithm.problems.backspacestringcompare;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        String S = "ab#c", T = "ad#c";
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
}