package us.supercheng.algorithm.problems.leetcode.reversewordsinastringiii;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        String s = "";
        PrintHelper.echoLn(new App().reverseWords(s));
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int eachLength = 0;
        for(int i=0;i<chars.length;i++) {
            if(chars[i] != ' ')
                eachLength++;
            if(chars[i] == ' ') {
                this.reverseWord(chars, i - eachLength, i-1);
                eachLength = 0;
            } else if (i == chars.length -1)
                this.reverseWord(chars, i - eachLength + 1, i);
        }
        return String.valueOf(chars);
    }

    private void reverseWord(char[] chars, int left, int right) {
        while(right > left) {
            char temp = chars[right];
            chars[right--] = chars[left];
            chars[left++] = temp;
        }
    }
}