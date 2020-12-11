package us.supercheng.algorithm.problems.leetcode.stringcompression;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        App app = new App();
        char [] arr = {'a','a','b','b','c','c','c'};
        PrintHelper.echoLn("Before Compression: " + String.valueOf(arr));
        int ret = app.compress(arr);
        PrintHelper.echoLn("After  Compression: " + String.valueOf(arr).substring(0,ret));
    }

    public int compress(char[] chars) {
        if(chars == null || chars.length < 1)
            return 0;
        StringBuffer sb = new StringBuffer();
        char prev = chars[0];
        int count = 1;
        for(int i=1;i<chars.length;i++) {
            if(chars[i] != prev) {
                sb.append(prev + (count > 1 ? count + "" : ""));
                count = 1;
            } else
                count++;
            prev = chars[i];
        }
        sb.append(prev + (count > 1 ? count + "" : ""));
        String s = sb.toString();
        for(int i=0;i<s.length();i++) {
            chars[i] = s.charAt(i);
        }
        return s.length();
    }
}