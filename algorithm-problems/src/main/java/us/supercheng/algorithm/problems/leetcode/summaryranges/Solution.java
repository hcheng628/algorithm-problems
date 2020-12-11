package us.supercheng.algorithm.problems.leetcode.summaryranges;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList();
        List<List<Integer>> list = new ArrayList();
        this.helper(nums, 0, list);

        for (List<Integer> tList : list)
            if(tList.size() == 1)
                ret.add(Integer.toString(tList.get(0)));
            else
                ret.add(Integer.toString(tList.get(0)) + "->" + Integer.toString(tList.get(tList.size()-1)));

        return ret;
    }

    private void helper(int[] nums, int index, List<List<Integer>> list) {
        if(index < nums.length) {
            if(index == 0 || nums[index] -  nums[index-1] != 1) {
                List<Integer> contList = new ArrayList();
                contList.add(nums[index]);
                list.add(contList);
            } else
                list.get(list.size()-1).add(nums[index]);
            this.helper(nums, index+1, list);
        }
    }
}