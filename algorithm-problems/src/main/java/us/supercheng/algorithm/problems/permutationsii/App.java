package us.supercheng.algorithm.problems.permutationsii;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.*;

public class App {

    public static void main(String[]  args) {
        int [] nums = {-1,2,-1,2,1,-1,2,1};
        List<List<Integer>> res = new App().permuteUnique(nums);
        for(List<Integer> row : res) {
            for(int each :  row) {
                PrintHelper.echo(each + ",");
            }
            PrintHelper.echoLn("");
        }

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        boolean [] used = new boolean[nums.length];
        this.helper(nums, new ArrayList(), ret, used);
        return ret;
    }

    private void helper(int [] nums, List<Integer> list, List<List<Integer>> ret, boolean [] used) {
        if(list.size() == nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(used[i] == true)
                continue;
            used[i] = true;
            list.add(nums[i]);
            this.helper(nums, list, ret, used);
            used[i] = false;
            list.remove(list.size()-1);
            for(;i<nums.length-1 && nums[i] == nums[i+1];i++);
        }
    }
}