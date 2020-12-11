package us.supercheng.algorithm.problems.leetcode.longestuncommonsubsequence;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String [] args) {
        String s = "Lakers";
        String t = "LosCity";
        PrintHelper.echoLn(new App().findLUSlength(s, t));
    }

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : (a.length() > b.length() ? a.length() : b.length());
    }
}