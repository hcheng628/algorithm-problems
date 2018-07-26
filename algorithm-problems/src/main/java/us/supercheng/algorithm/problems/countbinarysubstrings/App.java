package us.supercheng.algorithm.problems.countbinarysubstrings;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        String s = "00110011";
        PrintHelper.echoLn(new App().countBinarySubstrings(s));
        PrintHelper.echoLn(new App().countBinarySubstrings2(s));
    }

    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int ret = 0, count = 0;
        for(int index=0;index<chars.length;index++) {
            if(index-1 >=0 && chars[index] != chars[index-1]) {
                for(int i=0;i<count;i++) {
                    if(index+i <= chars.length -1 && index - i -1 >= 0 && chars[index+i] != chars[index-i-1])
                        ret++;
                    else
                        break;
                }
                count = 1;
            } else
                count++;
        }
        return ret;
    }

    public int countBinarySubstrings2(String s) {
        if ( s.length() == 0 ) return 0;

        int index = 0;
        char charNow = s.charAt(0);
        int lenNow = 0;
        int lenPre = 0;

        int count = 0;
        for(char c: s.toCharArray()){
            PrintHelper.echoLn("Before lenNow: " + lenNow + " lenPre: " + lenPre + " lenPre: " + lenPre + " count: " + count);
            if ( charNow == c )
                lenNow ++;
            else {
                count += Math.min(lenNow, lenPre);
                lenPre = lenNow;
                charNow = c;
                lenNow = 1;
            }
            PrintHelper.echoLn("After lenNow: " + lenNow + " lenPre: " + lenPre + " lenPre: " + lenPre + " count: " + count + "\n");
        }
        PrintHelper.echoLn("Final lenNow: " + lenNow + " lenPre: " + lenPre + " lenPre: " + lenPre + " count: " + count);
        count += Math.min(lenNow, lenPre);
        return count;
    }
}