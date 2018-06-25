package us.supercheng.algorithm.problems.base7;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        PrintHelper.echoLn(new App().convertToBase7(218263728));
    }

    public String convertToBase7(int num) {
        if(num < 7 && num > -7)
            return num + "";
        boolean posSign = num > 0;
        String ret = "";
        if(!posSign)
            num *= -1;
        for(;num != 0;num /= 7) {
            int mod = num % 7;
            ret = mod + ret;
        }
        return posSign == false ? "-" + ret : ret;
    }
}