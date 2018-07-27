package us.supercheng.algorithm.problems.degreeofanarray;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        int [] nums = {1,2,2,3,1,4,2};
        PrintHelper.echoLn(new App().findShortestSubArray(nums));
    }

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(), indexMap = new HashMap<>();
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                if(nums[i]!=0)
                    indexMap.put(nums[i], i);
                else
                    indexMap.put(50000, i);
            } else {
                map.put(nums[i], 1);
                if(nums[i]!= 0)
                    indexMap.put(-nums[i], i);
                else
                    indexMap.put(-50000,i);
            }
            if(map.get(nums[i]) > max)
                max = map.get(nums[i]);
        }

        int minDistance = Integer.MAX_VALUE;
        for(Integer key : map.keySet()) {
            if(map.get(key) == max) {
                if(key == 0)
                    key = 50000;
                Integer start = indexMap.get(-key), end = indexMap.get(key);
                if(end == null)
                    minDistance = 0;
                else if(minDistance > end - start)
                    minDistance = end - start;
            }
        }
        return minDistance + 1;
    }
}