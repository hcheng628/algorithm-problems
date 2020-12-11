package us.supercheng.algorithm.problems.leetcode.numberof1bits;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        int a = 7;
        while(a!=0) {
            System.out.println("a: " + a + "\r\n a: " + Integer.toBinaryString(a));
            a >>=1;
        }
        System.out.println("a: " + a + "\r\n a: " + Integer.toBinaryString(a));

        System.out.println(app.hammingWeight(52343221));
    }

    public int hammingWeight(int n) {
        int count = 0;
        for(int i=0; i<32;i++) {
            if((n & 1) == 1) {
                count++;
            }
            n >>=1;
        }
        return count;
    }
}