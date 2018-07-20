package us.supercheng.algorithm.problems.validpalindromeii;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        String s = "fdjasklhgjbjahu";
        PrintHelper.echoLn(new App().validPalindrome(s));
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
}