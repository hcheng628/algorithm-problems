package us.supercheng.algorithm.problems.validpalindrome;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.isPalindrome("I think this is working");
    }

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();
        int length = s.length();
        if(length < 2) {
            return true;
        }
        int index = length /2;
        if(index % 2 > 0) {
            index--;
        }
        if(index ==0) {
            index++;
        }
        for (int i=0;i<index;i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 -i)) {
                return false;
            }
        }
        return true;
    }
}
