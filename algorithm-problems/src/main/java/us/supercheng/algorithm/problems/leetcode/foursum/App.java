package us.supercheng.algorithm.problems.leetcode.foursum;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        int [] nums = {-9,4,0,-3,6,3,-3,-9,-7,1,0,-7,-8,7,1};
        int target = -9;
        for(List<Integer> row : new App().fourSum(nums, target)) {
            for(int each : row)
                PrintHelper.echo(each + " ");
            PrintHelper.echoLn("");
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums == null || nums.length<4)
            return ret;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j=i+1;j<nums.length-2;j++) {
                if(j-1 > i && nums[j]==nums[j-1])
                    continue;
                int left = j+1, right = nums.length -1;
                while(left < right) {
                    while(left-1 > j && nums[left] == nums[left-1] && left +1 <= right)
                        left++;
                    while(right+1 < nums.length -1 && nums[right] ==  nums[right +1] && right - 1 >= left)
                        right--;
                    if(left >= right)
                        break;
                    int temp = nums[i] + nums[left] + nums[j] +nums[right];
                    if(temp > target)
                        right--;
                    else if (temp < target)
                        left++;
                    else
                        ret.add(this.addRet(nums[i], nums[j], nums[left++], nums[right--]));
                }
            }
        }
        return ret;
    }

    private List<Integer> addRet(int a, int b, int c, int d) {
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        return list;
    }
}
