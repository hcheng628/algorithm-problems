package us.supercheng.algorithm.problems.tolowercase;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        String str = "THisjfash^32osd78hfeHUfajf";
        PrintHelper.echoLn(new App().toLowerCase(str));
    }

    public String toLowerCase(String str) {
        if(str == null || str.length() == 0)
            return "";

        char[] chars = str.toCharArray();

        for(int i=0;i<str.length();i++) {
            int aIndex = (int) chars[i];
            if(aIndex > 64 && aIndex < 91)
                chars[i] = (char) (aIndex + 32);
        }
        return String.valueOf(chars);
    }
}