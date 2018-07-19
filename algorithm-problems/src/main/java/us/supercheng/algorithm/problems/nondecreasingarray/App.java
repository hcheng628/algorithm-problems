package us.supercheng.algorithm.problems.nondecreasingarray;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int [] nums = {3,4,2,3};
        PrintHelper.echoLn(new App().checkPossibility(nums));
    }

    public boolean checkPossibility(int[] nums) {
        if(nums == null || nums.length < 2)
            return true;

        int count = 0;
        for(int i=1;i<nums.length;i++) {
            if(nums[i-1] > nums[i]) {
                if(i-2 >= 0 && nums[i-2] > nums[i])
                    nums[i] = nums[i-1];
                else
                    nums[i-1] = nums[i];
                count++;
                if(count ==2)
                    return false;
            }
        }
        return true;
    }
}