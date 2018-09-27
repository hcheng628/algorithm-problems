package us.supercheng.algorithm.problems.integertoroman;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int num = 2345;
        PrintHelper.echoLn("Int " + num + " is " + new App().intToRoman(num) + " in roman");
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<num / 1000;i++)
            sb.append("M");
        num %= 1000;

        for(int i=0;i<num / 900;i++)
            sb.append("CM");
        num %= 900;

        for(int i=0;i<num / 500;i++)
            sb.append("D");
        num %= 500;

        for(int i=0;i<num / 400;i++)
            sb.append("CD");
        num %= 400;

        for(int i=0;i<num / 100;i++)
            sb.append("C");
        num %= 100;

        for(int i=0;i<num / 90;i++)
            sb.append("XC");
        num %= 90;

        for(int i=0;i<num / 50;i++)
            sb.append("L");
        num %= 50;

        for(int i=0;i<num / 40;i++)
            sb.append("XL");
        num %= 40;

        for(int i=0;i<num / 10;i++)
            sb.append("X");
        num %= 10;

        for(int i=0;i<num / 9;i++)
            sb.append("IX");
        num %= 9;

        for(int i=0;i<num / 5;i++)
            sb.append("V");
        num %= 5;

        for(int i=0;i<num / 4;i++)
            sb.append("IV");
        num %= 4;

        for(int i=0;i<num / 1;i++)
            sb.append("I");
        return sb.toString();
    }
}