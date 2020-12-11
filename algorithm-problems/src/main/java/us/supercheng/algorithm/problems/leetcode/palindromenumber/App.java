package us.supercheng.algorithm.problems.leetcode.palindromenumber;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        System.out.println(app.isPalindrome(52343221));
    }

    public boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }

        String str = x + "";
        for(int i=0;i<str.length()/2;i++){
            if (str.charAt(i) != str.charAt(str.length() - i -1)) {
                return false;
            }
        }
        return true;
    }
}