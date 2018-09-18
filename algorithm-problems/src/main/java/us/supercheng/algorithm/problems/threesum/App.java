package us.supercheng.algorithm.problems.threesum;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        int [] nums = {-1,-1,-2,-3,-5,6,7,9,-1,0,1,2,-1,-4};
        List<List<Integer>> res = new App().threeSum(nums);
        for(List<Integer> row : res) {
            PrintHelper.echo("[ ");
            for(int col : row)
                PrintHelper.echo(col + " ");
            PrintHelper.echo("]");
            PrintHelper.echoLn("");
        }
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++) {
            int low = i+1, high = nums.length-1;
            if(i>0 && nums[i-1] == nums[i])
                continue;
            while(low<high) {
                if(nums[i]+nums[low]+nums[high] == 0) {
                    ret.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low<high && nums[low]==nums[low+1])
                        low++;
                    while(low<high && nums[high]==nums[high-1])
                        high--;
                    low++;
                } else if (nums[i]+nums[low]+nums[high] < 0)
                    low++;
                else
                    high--;
            }
        }
        return ret;
    }

}