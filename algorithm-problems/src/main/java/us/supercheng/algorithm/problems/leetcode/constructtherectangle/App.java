package us.supercheng.algorithm.problems.leetcode.constructtherectangle;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        PrintHelper.echoLn(Arrays.toString(new App().constructRectangle(10001)));
    }

    public int[] constructRectangle(int area) {
        int len = (int)(Math.sqrt(area));
        while(area % len != 0)
            --len;
        return new int[] {area/len, len};
    }
}