package us.supercheng.algorithm.problems.leetcode.maximumsubarray;

import java.util.Arrays;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        Integer [] arr = {-1,1,-3,4,-1,2,1,-5};
        int max = app.solution(arr);
        System.out.println("Max: " + max);
    }

    // -2, 1, -3, 4, -1, 2, 1, -5, 4
    public int solution(Integer[] nums) {
        int pre = nums[0];
        int max = nums[0];
        for(int i=1; i<nums.length; i++) {
            int sum = nums[i] + (pre > 0 ? pre : 0);
            pre = sum;
            max = Math.max(sum, max);
        }
        return max;
    }
}