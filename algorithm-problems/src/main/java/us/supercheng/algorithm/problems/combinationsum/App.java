package us.supercheng.algorithm.problems.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        for(int i=0;i<candidates.length;i++)
            this.helper(candidates, i, ret, candidates[i], target, new ArrayList<Integer>(Arrays.asList(candidates[i])));
        return ret;
    }

    private void helper(int[] nums, int index, List<List<Integer>> ret, int curVal, int target, ArrayList<Integer> list) {
        if(curVal > target)
            return;
        else if(curVal == target)
            ret.add(new ArrayList(list));
        else
            for(int i=index;i<nums.length;i++) {
                list.add(nums[i]);
                this.helper(nums, i, ret, curVal + nums[i], target, list);
                list.remove(list.size()-1);
            }
    }
}
