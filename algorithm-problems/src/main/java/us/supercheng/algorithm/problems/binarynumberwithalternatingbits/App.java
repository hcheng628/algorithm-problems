package us.supercheng.algorithm.problems.binarynumberwithalternatingbits;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int num = 321;
        PrintHelper.echoLn(new App().hasAlternatingBits(num));
        PrintHelper.echoLn(new App().hasAlternatingBits2(num));
    }

    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length-1;i++)
            if(chars[i] == chars[i+1])
                return false;
        return true;
    }

    public boolean hasAlternatingBits2(int n) {
        while (n != 0) {
            int prevBit = n & 1;
            PrintHelper.echoLn("B: " + Integer.toBinaryString(n));
            n = n >> 1;
            PrintHelper.echoLn("A: " + Integer.toBinaryString(n));
            int currBit = n & 1;
            PrintHelper.echoLn("Prev: " + Integer.toBinaryString(prevBit) + "\nCurr: " + Integer.toBinaryString(currBit));
            if (prevBit == currBit)
                return false;
        }
        return true;
    }
}