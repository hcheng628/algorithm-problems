package us.supercheng.algorithm.problems.numberofsegmentsinastring;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        App app = new App();
        String s = "Hello, my name is John";
        PrintHelper.echoLn(app.countSegments(s));
    }

    public int countSegments(String s) {
        int count = 0;
        s = s.trim();
        if(s == null || s.length()==0)
            return 0;
        char prev = '-';
        char [] arr = s.toCharArray();
        for(char each : arr) {
            if(each == ' ' && prev != ' ') {
                count++;
            }
            prev = each;
        }
        return count + 1;
    }
}