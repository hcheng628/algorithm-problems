package us.supercheng.algorithm.problems.singlenumber;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int [] arr = {2,1,3,4,3,1,2,4,5,6};
        int a = app.singleNumber(arr);
        System.out.println("Final Result: " + a);
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1;i += 2) {
            int num = nums[i];
            if(num != nums[i+1]) {
                return num;
            }
        }
        return nums[nums.length-1];
    }
}