package us.supercheng.algorithm.problems.leetcode.reversestringii;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 4;
        PrintHelper.echoLn(new App().reverseStr(s, k));
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        if(chars.length <= k) {
            this.reverseChars(chars, 0, chars.length -1);
            return String.valueOf(chars);
        }

        boolean oddFlag = true;
        int index = 0;
        while(index + k <= chars.length) {
            if(oddFlag)
                this.reverseChars(chars, index, index+(k-1));
            oddFlag = !oddFlag;
            index += k;
        }
        if(index > chars.length)
            this.reverseChars(chars, (index - k), chars.length -1);
        else if(index < chars.length && oddFlag)
            this.reverseChars(chars, index, chars.length -1);
        return String.valueOf(chars);
    }

    private void reverseChars(char [] chars, int left, int right) {
        while(right>left) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }

    public String reverseStr2(String s, int k) {
        if(s == null || k < 2 || s.length() < 2)
            return s;
        char [] chars = s.toCharArray();
        for(int i=0; i<chars.length;i+=2*k)
            this.reverseChars(chars,i, i+k-1 > chars.length - 1 ? chars.length -1 : i+k-1);
        return String.valueOf(chars);
    }
}