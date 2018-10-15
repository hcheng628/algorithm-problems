package us.supercheng.algorithm.problems.permutations;

import java.util.ArrayList;
import java.util.List;

public class App {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums == null)
            return ret;
        if(nums.length == 1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[0]);
            ret.add(temp);
            return ret;
        }

        for(int i=0;i<nums.length;i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            this.helper(nums, i, ret, list);
        }

        return ret;
    }

    private void helper(int[] nums, int index, List<List<Integer>> ret, List<Integer> list) {
        if(index > nums.length-1)
            return;

        if(list.size() == nums.length) {
            ret.add(list);
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(i!=index) {
                List<Integer> temp = new ArrayList<>();
                boolean dupFlag = false;
                for(Integer each : list) {
                    if(each == nums[i]) {
                        dupFlag = true;
                        break;
                    }
                    temp.add(each);
                }
                if(!dupFlag) {
                    temp.add(nums[i]);
                    this.helper(nums, i, ret, temp);
                }
            }
        }
    }
}