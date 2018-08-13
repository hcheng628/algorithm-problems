package us.supercheng.algorithm.problems.rotateddigits;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int N = 199;
        PrintHelper.echoLn(new App().rotatedDigits(N));
    }

    public int rotatedDigits(int N) {
        int ret = 0;
        for(int i=1;i<=N;i++) {
            boolean flag = false;
            for(int each=i;each>0;each/=10) {
                int eachDigit = each % 10;
                if(eachDigit == 3 || eachDigit == 4 || eachDigit == 7) {
                    flag = false;
                    break;
                }
                if(eachDigit == 2 || eachDigit == 5 || eachDigit == 6 || eachDigit == 9)
                    flag = true;
            }
            if(flag)
                ret++;
        }
        return ret;
    }
}