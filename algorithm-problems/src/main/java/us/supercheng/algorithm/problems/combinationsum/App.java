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
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);

        this.dfs(candidates, target, ret, new ArrayList<>(), 0);
        return ret;
    }

    private void dfs(int[] nums, int target, List<List<Integer>> ret, List<Integer> list, int idx) {
        for (int i=idx;i<nums.length;i++) {
            int newTarget = target-nums[i];
            if (newTarget < 0)
                break;
            else {
                list.add(nums[i]);
                if (newTarget == 0) {
                    ret.add(new ArrayList<>(list));
                    list.remove(list.size()-1);
                    break;
                }
                this.dfs(nums, target - nums[i], ret, list, i);
                list.remove(list.size()-1);
            }
        }
    }
}