package us.supercheng.algorithm.problems.leetcode.numberofunequaltripletsinarray;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int unequalTriplets(int[] nums) {
        int ret = 0;
        int left = 0;
        int right = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();

        for (int n : nums)
            cnt.put(n, cnt.getOrDefault(n, 0) + 1);

        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            int mid = e.getValue();
            right -= mid;
            ret += left * mid * right;
            left += mid;
        }

        return ret;
    }

}
