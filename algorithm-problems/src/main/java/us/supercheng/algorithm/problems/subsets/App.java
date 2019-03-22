package us.supercheng.algorithm.problems.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums == null)
            return ret;
        ret.add(new ArrayList());
        if(nums.length > 0) {
            Arrays.sort(nums);
            this.helper(nums, ret, new ArrayList(), 0);
        }
        return ret;
    }

    private void helper(int[] nums, List<List<Integer>> ret, List<Integer> list, int index) {
        if(index > nums.length - 1)
            return;
        for(int i=index;i<nums.length;i++)
            if(list.size() == 0 || list.get(list.size()-1) < nums[i]) {
                list.add(nums[i]);
                ret.add(new ArrayList<>(list));
                this.helper(nums, ret, list, index+1);
                list.remove(list.size()-1);
            }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums != null && nums.length > 0) {
            this.dfsSubSets(ret, nums, 0, new ArrayList<>());
            ret.add(new ArrayList<>());
        }
        return ret;
    }

    private void dfsSubSets(List<List<Integer>> ret, int[] nums, int idx, List<Integer> list) {
        for (int i=idx;i<nums.length;i++) {
            list.add(nums[i]);
            ret.add(new ArrayList<>(list));
            this.dfsSubSets(ret, nums, i+1, list);
            list.remove(list.size()-1);
        }
    }
}