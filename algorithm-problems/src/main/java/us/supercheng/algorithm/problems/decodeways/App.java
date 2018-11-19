package us.supercheng.algorithm.problems.decodeways;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        PrintHelper.echoLn(new App().numDecodings("226"));
    }

    public int numDecodingsSlow(String s) {
        char [] chars = s.toCharArray();
        int [] dp = new int [s.length()+1];
        dp[0] = 1;
        dp[1] = chars[0] == '0' ? 0 : 1;

        for(int i=2, charIndex=1;i<dp.length;i++, charIndex++) {
            if(dp[i-1] == 0 && dp[i-2] == 0)
                return 0;
            int twoDigits = Integer.valueOf(chars[charIndex-1] + "" + chars[charIndex]);
            int currDigit = chars[charIndex] - 48;
            if(twoDigits>= 10 && twoDigits <= 26)
                dp[i] += dp[i-2];
            if(currDigit >= 1 && currDigit <= 9)
                dp[i] += dp[i-1];
        }
        return dp[dp.length-1];
    }

    public int numDecodings(String s) {
        char [] chars = s.toCharArray();
        int prePre = 1,
            pre = chars[0] == '0' ? 0 : 1,
            size = chars.length + 1;

        for(int i=2;i<size;i++) {
            int curr = 0;
            if(prePre == 0 && pre == 0)
                return 0;
            int twoDigits = Integer.valueOf(chars[i-2] + "" + chars[i-1]);
            int currDigit = chars[i-1] - 48;
            if(twoDigits>= 10 && twoDigits <= 26)
                curr += prePre;
            if(currDigit >= 1 && currDigit <= 9)
                curr += pre;
            prePre = pre;
            pre = curr;
        }
        return pre;
    }
}