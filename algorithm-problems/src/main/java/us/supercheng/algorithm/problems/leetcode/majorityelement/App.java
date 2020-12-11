package us.supercheng.algorithm.problems.leetcode.majorityelement;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        App app = new App();
        int [] num = {2,2,1,1,1,2,2,2};
        System.out.println(app.majorityElement(num));
        System.out.println(app.majorityElement1(num));
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int prevNum = nums[0];
        int count = 1;
        int size = nums.length / 2;
        int returnVal = prevNum;
        if(nums.length % 2 != 0) {
            size++;
        }
        for(int i=1;i<nums.length;i++) {
            int currNum = nums[i];
            if (currNum == prevNum) {
                count++;
            } else {
                prevNum = currNum;
                count = 1;
            }
            if(count == size) {
                returnVal = currNum;
                break;
            }
        }
        return returnVal;
    }

    public int majorityElement1(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}