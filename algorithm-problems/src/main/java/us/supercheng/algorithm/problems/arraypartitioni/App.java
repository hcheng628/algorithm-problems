package us.supercheng.algorithm.problems.arraypartitioni;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Arrays;

public class App {

    public static void main(String [] args) {
        int [] nums = {1,3,5,13,2,4,2,1,34,5,43,2,32,22};
        PrintHelper.echoLn(new App().arrayPairSum(nums));
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for(int i=0; i<=nums.length-2; i+=2)
            ret += nums[i];
        return ret;
    }
}
