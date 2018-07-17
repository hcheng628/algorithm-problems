package us.supercheng.algorithm.problems.setmismatch;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int [] nums = {1,2,2,4};
        PrintHelper.echoLn(new App().findErrorNums(nums));
    }

    public int[] findErrorNums(int[] nums) {
        int [] bucket = new int [nums.length + 1];
        for(int i=0;i<nums.length;i++)
            bucket[nums[i]]++;

        int num = -1;
        int prev = -1;
        for(int i=0;i<bucket.length;i++) {
            if(bucket[i] == 2) {
                num = i;
                break;
            }
        }

        for(int i=1;i<num;i++) {
            if(bucket[i]==0)
                prev = i;
        }

        if(prev == -1) {
            for(int i=num + 1;i<bucket.length;i++) {
                if(bucket[i] == 0) {
                    prev = i;
                    break;
                }
            }
        }

        int [] ret = new int[2];
        ret[0] = num;
        ret[1] = prev;
        return ret;
    }
}