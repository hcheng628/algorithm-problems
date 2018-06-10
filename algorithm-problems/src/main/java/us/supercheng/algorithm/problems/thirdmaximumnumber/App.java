package us.supercheng.algorithm.problems.thirdmaximumnumber;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,2,1,3,45,2,4,2,1,323,1,2};
        PrintHelper.echoLn("thirdMax: " + new App().thirdMax(arr));
    }

    public int thirdMax(int[] nums) {
        if(nums.length== 1)
            return nums[0];
        Arrays.sort(nums);
        int count = 0;
        List<Integer> list = new ArrayList<>();
        int prev = nums[nums.length-1];
        list.add(nums[nums.length-1]);
        for(int i= nums.length-2;i>=0;i--) {
            if(nums[i]!= prev) {
                list.add(nums[i]);
                prev = nums[i];
                count++;
                if(count == 3) {
                    break;
                }
            }
        }
        if(list.size() < 3) {
            return list.get(0);
        } else {
            return list.get(2);
        }
    }
}