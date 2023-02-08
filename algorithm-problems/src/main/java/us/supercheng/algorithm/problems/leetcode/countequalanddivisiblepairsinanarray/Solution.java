package us.supercheng.algorithm.problems.leetcode.countequalanddivisiblepairsinanarray;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int countPairs(int[] nums, int k) {
        int ret = 0;
        List<Integer>[] idxes = new ArrayList[101];

        for (int i = 0, len = nums.length; i < len; i++) {
            for (int j = 0; idxes[nums[i]] != null && j < idxes[nums[i]].size(); j++)
                if (i * idxes[nums[i]].get(j) % k == 0)
                    ret++;

            if (idxes[nums[i]] == null)
                idxes[nums[i]] = new ArrayList<>();
            idxes[nums[i]].add(i);
        }

        return ret;
    }

}
