package us.supercheng.algorithm.problems.validpalindromeii;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        String s = "fdjasklhgjbjahu";
        PrintHelper.echoLn(new App().validPalindrome(s));
        PrintHelper.echoLn(new App().validPalindrome2(s));
    }

    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left=0, right = chars.length -1;

        int count = 0;
        boolean ret = true;
        while(left<right) {
            if(chars[left] != chars[right]){
                if(this.helper(chars, left) || this.helper(chars, right))
                    return true;
                else
                    ret = false;

                count++;
                if(count == 2)
                    return false;
            }
            left++;
            right--;
        }
        return ret;
    }

    private boolean helper(char[] chars, int index) {
        int left =0, right = chars.length-1;
        while(left < right) {
            if(left == index)
                left++;
            if(right == index)
                right--;
            if(chars[left] != chars[right])
                return false;
            left++;
            right--;
        }
        return true;
    }

    public boolean validPalindrome2(String s) {
        if(s == null || s.length() < 2)
            return true;
        char[] chars = s.toCharArray();
        int left=0, right = chars.length -1;
        return helper2(chars, left, right, 0) < 2;
    }

    private int helper2(char[] chars, int left, int right, int diff) {
        if(left > right || diff > 1)
            return 2;
        while(left <= right && chars[left] == chars[right]) {
            left++;
            right--;
        }
        if(left > right)
            return 0;
        else
            return helper2(chars, left + 1, right, diff + 1) <= 1 || helper2(chars, left, right - 1, diff + 1) <= 1 ? 1 : 2;
    }
}