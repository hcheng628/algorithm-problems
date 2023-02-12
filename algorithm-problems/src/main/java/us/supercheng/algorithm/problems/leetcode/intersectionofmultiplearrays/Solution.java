package us.supercheng.algorithm.problems.leetcode.intersectionofmultiplearrays;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> intersection(int[][] nums) {
        int[] count = new int[1001];
        List<Integer> ret = new ArrayList<>();

        for (int[] num : nums)
            for (int n : num)
                count[n]++;

        for (int i = 0, len = nums.length; i < 1001; i++)
            if (count[i] == len)
                ret.add(i);

        return ret;
    }

}
