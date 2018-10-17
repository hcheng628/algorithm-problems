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
        Set<List<Integer>> set = new HashSet<>();
        this.helper(nums, new ArrayList(), set);
        for(List<Integer> each : set)
            ret.add(each);
        return ret;
    }

    private void helper(int [] nums, List<Integer> list, Set<List<Integer>> set) {
        if(list.size() == nums.length) {
            List<Integer> temp = new ArrayList<>(list);
            List<Integer> temp2 = new ArrayList<>(temp);
            Collections.sort(temp2);
            for(int i=0;i<nums.length;i++)
                if(temp2.get(i) != nums[i])
                    return;
            if(!set.contains(temp)) {
                set.add(temp);
            }
            return;
        }

        for(int i=0;i<nums.length;i++) {
            list.add(nums[i]);
            this.helper(nums, list, set);
            list.remove(list.size()-1);
        }
    }
}