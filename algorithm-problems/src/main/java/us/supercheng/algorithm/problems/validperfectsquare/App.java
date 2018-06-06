package us.supercheng.algorithm.problems.validperfectsquare;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        App app = new App();
        PrintHelper.echoLn(app.isPerfectSquare(282918));
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
}