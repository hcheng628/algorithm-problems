package us.supercheng.algorithm.problems.maximumproductofthreenumbers;

import java.util.Arrays;

public class App {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return  Math.max(nums[nums.length-3] * nums[nums.length-2] * nums[nums.length-1], nums[0] * nums[1] * nums[nums.length-1]);
    }
}