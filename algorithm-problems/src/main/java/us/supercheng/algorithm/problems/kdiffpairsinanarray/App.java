package us.supercheng.algorithm.problems.kdiffpairsinanarray;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        int target = 1;
        PrintHelper.echoLn(new App().findPairs(nums, target));
    }

    public int findPairs(int[] nums, int target) {
        if(target<0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int each : nums) {
            if(map.containsKey(each))
                map.put(each, 2);
            else
                map.put(each, 1);
        }
        if(target == 0) {
            int dup = 0;
            for(int key : map.keySet()) {
                if(map.get(key)>1)
                    dup++;
            }
            return dup;
        }
        int i=0;
        for(int each : map.keySet())
            nums[i++]=each;
        int count = 0;
        for(int j=0;j<i;j++) {
            for(int k=j+1;k<i;k++) {
                if(Math.abs(nums[j] - nums[k]) == target)
                    count++;
            }
        }
        return count;
    }
}