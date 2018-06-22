package us.supercheng.algorithm.problems.maxconsecutiveones;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String [] args) {
        int [] nums = {1,1,0,1,1,1};
        PrintHelper.echoLn(new App().findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int ret = 0;
        int counter = 0;
        for(int each : nums) {
            if(each == 1)
                counter++;
            else {
                ret = Math.max(counter, ret);
                counter = 0;
            }
        }
        ret = Math.max(counter, ret);
        return ret;
    }
}