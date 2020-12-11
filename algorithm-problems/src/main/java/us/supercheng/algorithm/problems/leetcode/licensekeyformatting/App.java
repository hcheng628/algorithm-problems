package us.supercheng.algorithm.problems.leetcode.licensekeyformatting;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        String s = "5F3Z-2e-9-w";
        int k = 3;
        PrintHelper.echoLn(new App().licenseKeyFormatting(s, k));
        PrintHelper.echoLn(new App().licenseKeyFormatting2(s, k));
    }

    public String licenseKeyFormatting2(String S, int K) {
        int addDashIndex = K;
        char [] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=chars.length-1;i>=0;i--) {
            if(chars[i] == '-')
                continue;
            if(addDashIndex == 0) {
                sb.append('-');
                addDashIndex = K;
            }
            sb.append(chars[i]);
            addDashIndex--;
        }
        return sb.reverse().toString().toUpperCase();
    }

    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "");
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int i=S.length()-1;
        while(i>=K-1) {
            sb.append(temp.append(S.substring(i-K + 1,i+1)).reverse());
            if(i != K-1) {
                sb.append("-");
            }
            i-=K;
            temp.setLength(0);
        }
        if(i != -1) {
            sb.append(temp.append(S.substring(0,i+1)).reverse());
        }
        return sb.reverse().toString().toUpperCase();
    }
}