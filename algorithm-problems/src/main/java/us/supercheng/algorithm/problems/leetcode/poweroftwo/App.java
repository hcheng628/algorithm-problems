package us.supercheng.algorithm.problems.leetcode.poweroftwo;

public class App {

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.isPowerOfTwo(100));
    }

    public boolean isPowerOfTwo(int n) {
        if(n < 1) {
            return false;
        }
        while(n!= 1) {
            if(n%2 != 0) {
                return false;
            }
            n=n/2;
        }
        return true;
    }
}
