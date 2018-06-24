package us.supercheng.algorithm.problems.largestpalindromeproduct;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int a = 91 * 44;
        PrintHelper.echoLn(new App().isPalindrome2(a));
        PrintHelper.echoLn(new App().largestPalindrome(3));
        PrintHelper.echoLn(new App().largestPalindrome2(3));
    }

    public int largestPalindrome2(int n) {
        if(n == 1)
            return 9;
        int upper = (int)Math.pow(10, n) - 1;
        int lower = upper / 10 + 1;
        for(int i= upper; i>lower;i--) {
            long palindrome = Long.parseLong(i + new StringBuilder().append(i).reverse().toString());
            for(int j=upper; j>lower;j--) {
                if(upper < palindrome / j)
                    break;
                if(palindrome % j == 0)
                    return (int) (palindrome % 1337);
            }
        }
        return -1;
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