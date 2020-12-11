package us.supercheng.algorithm.problems.leetcode.combinationsumii;

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

    public List<List<Integer>> combinationSum2B(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        this.dfs(ret, candidates, target, new ArrayList<>(), 0);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, int[] nums, int target, List<Integer> list, int idx) {
        int prev = -1;
        for (int i=idx;i<nums.length;prev = nums[i],i++) {
            int newTarget = target - nums[i];
            if (newTarget < 0)
                return;
            else if (newTarget == 0) {
                list.add(nums[i]);
                ret.add(new ArrayList<>(list));
                list.remove(list.size()-1);
                return;
            } else if (nums[i] != prev) {
                list.add(nums[i]);
                this.dfs(ret, nums, newTarget, list, i+1);
                list.remove(list.size()-1);
            }
        }
    }
}