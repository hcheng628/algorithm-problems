package us.supercheng.algorithm.problems.rotatestring;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        String A = "abcde", B = "cdeab";
        PrintHelper.echoLn(new App().rotateString(A, B));
        PrintHelper.echoLn(new App().rotateString1(A, B));
    }

    public boolean rotateString(String A, String B) {
        if(A == null && B == null)
            return true;
        if(A == null || B == null || A.length() != B.length())
            return false;
        return (A+A).contains(B);
    }

    public boolean rotateString1(String A, String B) {
        if(A == null && B == null || A.length() == 0 && B.length() == 0)
            return true;
        if(A.length() != B.length() || A == null || B == null)
            return false;

        for(int i=0;i<A.length()-1;i++) {
            A = A.substring(1,A.length()) + A.charAt(0);
            if(B.contains(A))
                return true;
        }
        return false;
    }
}