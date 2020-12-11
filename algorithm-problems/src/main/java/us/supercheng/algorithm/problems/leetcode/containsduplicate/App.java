package us.supercheng.algorithm.problems.leetcode.containsduplicate;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.containsDuplicate(null);
    }

    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length < 2) {
            return false;
        }
        Arrays.sort(nums);
        int pre = nums[0];
        for(int i=1;i<nums.length;i++) {
            if(nums[i] == pre) {
                return true;
            }
            pre = nums[i];
        }
        return false;
    }
}
