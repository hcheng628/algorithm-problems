package us.supercheng.algorithm.problems.binarynumberwithalternatingbits;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int num = 321;
        PrintHelper.echoLn(new App().hasAlternatingBits(num));
    }

    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length-1;i++)
            if(chars[i] == chars[i+1])
                return false;
        return true;
    }
}