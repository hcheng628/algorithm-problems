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
}
