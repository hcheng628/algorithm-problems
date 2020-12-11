package us.supercheng.algorithm.problems.leetcode.relativeranks;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Arrays;
import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        int [] nums = {5, 4, 3, 2, 1, 45, 12, 2432, 13, 34, 42};
        PrintHelper.echoLn(Arrays.toString(new App().findRelativeRanks(nums)));
    }

    public String[] findRelativeRanks(int[] nums) {
        int [] backup = new int [nums.length];
        for(int i=0;i<nums.length;i++)
            backup[i] = nums[i];
        Arrays.sort(nums);
        String[] ret = new String[nums.length];
        HashMap<Integer, String> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(i == nums.length - 1 && nums.length - 1 >= 0)
                map.put(nums[i], "Gold Medal");
            else if (i == nums.length - 2 && nums.length - 2 >= 0 )
                map.put(nums[i], "Silver Medal");
            else if(i == nums.length -3 && nums.length - 3 >= 0)
                map.put(nums[i], "Bronze Medal");
            else
                map.put(nums[i],nums.length - i + "");
        }
        for(int i=0;i<backup.length;i++)
            ret[i] = map.get(backup[i]);
        return ret;
    }
}