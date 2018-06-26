package us.supercheng.algorithm.problems.detectcapital;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        String s = "CHINAJAPANNORTHKOREA";
        PrintHelper.echoLn(new App().detectCapitalUse(s));
    }

    public boolean detectCapitalUse(String word) {
        if(word.length() == 1)
            return true;

        char[] chars = word.toCharArray();

        boolean firstCap = false;
        boolean lowCapFlag = false;
        boolean upperCapFlag = false;

        if(chars[0] < 'a')
            firstCap = true;

        for(int i=1;i<chars.length;i++) {
            if(chars[i] < 'a')
                upperCapFlag = true;
            if(chars[i] >= 'a')
                lowCapFlag = true;
        }

        if(firstCap) {
            if(upperCapFlag && !lowCapFlag)
                return true;
            else if(!upperCapFlag && lowCapFlag)
                return true;
        } else {
            if(!upperCapFlag && lowCapFlag)
                return true;
        }
        return false;
    }
}