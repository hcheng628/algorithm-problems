package us.supercheng.algorithm.problems.stringtointegeratoi;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        String str = "  0000000000012345678";
        PrintHelper.echoLn(new App().myAtoi(str));
    }

    public int myAtoi(String str) {
        if(str == null || str.trim().length() < 1)
            return 0;
        str = str.trim();
        int index = 0;
        char[] chars = str.toCharArray();
        boolean negNum = chars[index] == '-';
        if(negNum || (!negNum && chars[index] == '+'))
            index++;
        double ret = 0.0;
        for(;index < chars.length && chars[index] >= '0' && chars[index] <= '9';index++)
            ret = ret * 10 + (chars[index] - 48);
        if(negNum) {
            ret = ret * -1;
            if(ret < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        } else
        if(ret > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int)ret;
    }
}
