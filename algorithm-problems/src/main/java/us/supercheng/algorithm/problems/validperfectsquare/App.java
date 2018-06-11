package us.supercheng.algorithm.problems.validperfectsquare;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        App app = new App();

        int num = 230*230;
        PrintHelper.echoLn(app.isPerfectSquare(num));
        PrintHelper.echoLn(app.isPerfectSquare2(num));
    }

    public boolean isPerfectSquare(int num) {
        if(num < 20000) {
            for(int i=1;i<20000;i++) {
                if(i*i == num) {
                    return true;
                }
            }
        } else {
            for(int i=46340;i>0;i--) {
                if(i*i == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        int left = 1;
        int right = num / 2 + 1;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            long res = mid * mid;
            if(res == num)
                return true;
            else if(res > num)
                right = (int)mid -1;
            else
                left = (int) mid + 1;
        }
        return false;
    }
}