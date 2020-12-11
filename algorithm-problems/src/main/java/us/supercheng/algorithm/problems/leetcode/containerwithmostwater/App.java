package us.supercheng.algorithm.problems.leetcode.containerwithmostwater;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        PrintHelper.echoLn("Max: " + new App().maxArea(height));
    }

    public int maxArea(int[] height) {
        int ret = 0;
        for(int right = 1;right <= height.length-1;right++)
            for(int temp = 0; temp < right;temp++) {
                int res = (right - temp) * (height[temp] < height[right] ? height[temp] : height[right]);
                if(res > ret)
                    ret = res;
            }
        return ret;
    }
}
