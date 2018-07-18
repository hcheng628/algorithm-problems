package us.supercheng.algorithm.problems.maximumproductofthreenumbers;

import java.util.Arrays;

public class App {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return  Math.max(nums[nums.length-3] * nums[nums.length-2] * nums[nums.length-1], nums[0] * nums[1] * nums[nums.length-1]);
    }

    public int maximumProduct2(int[] nums) {
        int maxMax = Integer.MIN_VALUE, maxMid = Integer.MIN_VALUE, maxMin = Integer.MIN_VALUE,
            minMax = Integer.MAX_VALUE, minMin = Integer.MAX_VALUE;
        for(int each : nums) {
            if(each > maxMax) {
                maxMin = maxMid;
                maxMid = maxMax;
                maxMax = each;
            } else if (each > maxMid) {
                maxMin = maxMid;
                maxMid = each;
            } else if (each > maxMin)
                maxMin = each;

            if(each < minMin) {
                minMax = minMin;
                minMin = each;
            } else if (each < minMax)
                minMax = each;
        }
        return Math.max(minMin * minMax, maxMin * maxMid) * maxMax;
    }
}