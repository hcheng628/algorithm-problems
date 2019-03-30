package us.supercheng.algorithm.problems.wigglesubsequence;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return 1;

        int max = 1;
        List<Integer> diffs = new ArrayList<>();

        for (int i=1,j=0; i<nums.length; i++,j++)
            if (nums[i] - nums[j] != 0)
                diffs.add(nums[i] - nums[j]);

        if (diffs.size() == 0)
            return max;

        for (int i=0;i<diffs.size();i++)
            max = Math.max(this.maxLength(diffs, i), max);

        return max+1;
    }

    private int maxLength(List<Integer> list, int idx) {
        boolean isPositive = list.get(idx) > 0;
        int ret = 1;

        for (int i=idx+1;i<list.size();i++)
            if (isPositive != list.get(i)>0) {
                ret++;
                isPositive =!isPositive;
            }
        return ret;
    }
}