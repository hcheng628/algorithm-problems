package us.supercheng.algorithm.problems.largestnumberatleasttwiceofothers;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String [] args) {
        int [] nums = {3, 6, 1, 0};
        PrintHelper.echoLn(new App().dominantIndex(nums));
    }


    public int dominantIndex(int[] nums) {
        int [] bucket = new int [101];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(max < nums[i])
                max = nums[i];
            bucket[nums[i]] = i+1;
        }
        for(int i=0;i<bucket.length;i++) {
            if(bucket[i] > 0 && i != max && i*2 > max)
                return -1;
        }
        return bucket[max] - 1;
    }
}