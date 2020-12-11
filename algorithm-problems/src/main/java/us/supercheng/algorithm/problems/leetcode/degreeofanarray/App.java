package us.supercheng.algorithm.problems.leetcode.degreeofanarray;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        int [] nums = {1,2,2,3,1,4,2};
        PrintHelper.echoLn(new App().findShortestSubArray2(nums));
        PrintHelper.echoLn(new App().findShortestSubArray(nums));
    }

    public int findShortestSubArray2(int[] nums) {
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

    public int findShortestSubArray(int[] nums) {
        if(nums.length < 2)
            return 1;
        HashMap<Integer, int []> map = new HashMap<>();
        int maxOcc = 1;
        for(int i=0;i<nums.length;i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i], new int [] {1, i, i});
            else {
                int [] num = map.get(nums[i]);
                num[0]++;
                if(num[0] > maxOcc)
                    maxOcc = num[0];
                num[2] = i;
            }
        }

        int ret = Integer.MAX_VALUE;
        for(int key : map.keySet()) {
            if(map.get(key)[0] == maxOcc) {
                if(map.get(key)[2] - map.get(key)[1] + 1 < ret)
                    ret = map.get(key)[2] - map.get(key)[1] + 1;
            }
        }
        return ret;
    }
}