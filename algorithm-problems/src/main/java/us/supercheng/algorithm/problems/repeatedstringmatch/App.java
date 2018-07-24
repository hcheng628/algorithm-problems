package us.supercheng.algorithm.problems.repeatedstringmatch;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        String A =  "abcd";
        String B=  "cdabcdab";
        PrintHelper.echoLn(new App().repeatedStringMatch(A, B));
    }

    public int repeatedStringMatch(String A, String B) {
        int counter = 1;
        StringBuilder sb = new StringBuilder(A);
        while(sb.length() < B.length()) {
            sb.append(A);
            counter++;
        }

        if(sb.toString().contains(B))
            return counter;

        sb.append(A);
        if(sb.toString().contains(B))
            return counter + 1;
        return -1;
    }
}