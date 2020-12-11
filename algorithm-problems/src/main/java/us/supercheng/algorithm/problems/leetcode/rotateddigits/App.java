package us.supercheng.algorithm.problems.leetcode.rotateddigits;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int N = 199;
        PrintHelper.echoLn(new App().rotatedDigits(N));
        PrintHelper.echoLn(new App().rotatedDigits1(N));
    }

    public int rotatedDigits1(int N) {
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

    // beautiful brainy dp
    public int rotatedDigits(int N) {
        int [] dp = new int[N+1];
        int ret = 0;
        for (int i=0;i<=N;i++) {
            if(i<10) {
                if(i == 0 || i == 1 || i == 8) {
                    dp[i] = 1;
                } else if (i == 2 || i == 5 || i == 6 || i ==9) {
                    dp[i] = 2;
                    ret++;
                }
            } else {
                int dpLookup = dp[i/10], lastDigit = dp[i%10];
                if(dpLookup == 1 && lastDigit == 1)
                    dp[i] = 1;
                else if(dpLookup !=0 && lastDigit != 0) {
                    dp[i] = 2;
                    ret++;
                }
            }
        }
        return ret;
    }
}