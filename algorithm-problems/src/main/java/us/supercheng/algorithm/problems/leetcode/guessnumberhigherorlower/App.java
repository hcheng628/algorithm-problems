package us.supercheng.algorithm.problems.leetcode.guessnumberhigherorlower;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String [] args) {
        App app = new App();
        PrintHelper.echoLn(app.guessNumber(100));
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //System.out.println("Left: " + left + " Right: " + right + " Mid: " + mid);
            int ret = this.guess(mid);
            if (ret == 0) {
                return mid;
            } else if (ret == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     The guess API is defined in the parent class GuessGame.
     @param num, your guess
     @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
     int guess(int num);
     */
    public int guess(int num) {
        return 13; // cannot test here
    }
}