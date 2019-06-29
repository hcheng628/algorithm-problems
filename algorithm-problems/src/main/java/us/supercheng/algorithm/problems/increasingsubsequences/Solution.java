package us.supercheng.algorithm.problems.increasingsubsequences;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        if (nums == null || nums.length < 1)
            return retList;
        this.findSeq(nums, 0, new ArrayList(), retList);
        return retList;
    }

    private void findSeq(int[] nums, int idx, List<Integer> list, List<List<Integer>> retList) {
        if (list.size() > 1)
            retList.add(new ArrayList<>(list));

        if (idx >= nums.length)
            return;

        boolean[] startedFrom = new boolean[201];

        for (int i=idx;i<nums.length;i++) {
            int startedFromIdx = nums[i] + 100;
            if (startedFrom[startedFromIdx])
                continue;
            startedFrom[startedFromIdx] = true;

            if (list.isEmpty() || nums[i] >= list.get(list.size()-1)) {
                list.add(nums[i]);
                this.findSeq(nums, i+1, list, retList);
                list.remove(list.size()-1);
            }
        }
    }
}