package us.supercheng.algorithm.problems.largestpalindromeproduct;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int a = 91 * 44;
        PrintHelper.echoLn(new App().isPalindrome2(a));
        PrintHelper.echoLn(new App().largestPalindrome(2));
    }

    public int largestPalindrome(int n) {
        long a = (long) Math.pow(10, n) - 1;
        long b;
        int ret = 0;
        while (a > 0) {
            b = a;
            while(b > 0) {
                long temp = a * b;
                if(this.isPalindrome2(temp)) {
                    ret = Math.max((int)temp, ret);
                }
                b--;
            }
            a--;
        }
        return ret%1337;
    }


    private boolean isPalindrome2(long num) {
        String s = num + "";
        StringBuilder sb = new StringBuilder();
        if(s.length() % 2 != 0) {
            sb.append(s.substring(s.length() / 2 + 1, s.length()));
        } else
            sb.append(s.substring(s.length() / 2, s.length()));
        return sb.reverse().toString().equals(s.substring(0, s.length()/2));
    }

    private boolean isPalindrome(long num) {
        String s = num + "";
        int left = 0;
        int right = s.length() - 1;
        while (right > left) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            right--;
            left++;
        }
        return true;
    }
}