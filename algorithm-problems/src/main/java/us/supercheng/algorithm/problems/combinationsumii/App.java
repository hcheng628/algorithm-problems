package us.supercheng.algorithm.problems.combinationsumii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        for(int i=0;i<candidates.length;i++) {
            if(i>0 && candidates[i] != candidates[i-1])
                this.helper(candidates, i, ret, candidates[i], target, new ArrayList<Integer>(Arrays.asList(candidates[i])));
            if(i==0)
                this.helper(candidates, i, ret, candidates[i], target, new ArrayList<Integer>(Arrays.asList(candidates[i])));
        }
        return ret;
    }

    private void helper(int[] nums, int index, List<List<Integer>> ret, int curVal, int target, ArrayList<Integer> list) {
        if(curVal > target)
            return;
        else if(curVal == target)
            ret.add(new ArrayList(list));
        else
            for(int i=index+1;i<nums.length;i++) {
                list.add(nums[i]);
                this.helper(nums, i, ret, curVal + nums[i], target, list);
                for(;i<nums.length-1 && nums[i] == nums[i+1];i++);
                list.remove(list.size()-1);
            }
    }
}