package us.supercheng.algorithm.problems.leetcode.longestpalindromicsubstring;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String [] args) {
        String s = "abaabaababsahasjklaadsdsdsss";
        PrintHelper.echoLn(new App().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char [] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++) {
            this.calCount(1, chars, i, i-1, i+1, sb, s);
            if(sb.length() < 1)
                sb.append(String.valueOf(chars[i]));
            if(i+1 <= chars.length -1 && chars[i] == chars[i+1]) {
                this.calCount(2, chars, i, i-1, i+2, sb, s);
                if(sb.length() < 2) {
                    sb.setLength(0);
                    sb.append(String.valueOf(chars[i]) + chars[i]);
                }
            }
        }
        return sb.toString();
    }

    private void calCount(int oddOrEven, char[] chars, int index, int left, int right, StringBuilder sb, String s) {
        int count = 0;
        while(left >=0 && right < chars.length) {
            if(chars[left] == chars[right]) {
                left--;
                right++;
                count++;
            } else
                break;
        }
        if(count * 2 + oddOrEven >= sb.length()) {
            sb.setLength(0);
            sb.append(s.substring(index-count, index + count + oddOrEven));
        }
    }
}
