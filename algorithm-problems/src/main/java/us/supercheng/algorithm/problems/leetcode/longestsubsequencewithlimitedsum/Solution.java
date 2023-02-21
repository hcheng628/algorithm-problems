package us.supercheng.algorithm.problems.leetcode.longestsubsequencewithlimitedsum;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

class Solution {

    public int[] answerQueries(int[] nums, int[] queries) {
        int len = queries.length;
        int nLen = nums.length;
        int[] ret = new int[len];

        Arrays.sort(nums);
        for (int i = 1; i < nLen; i++)
            nums[i] += nums[i - 1];

        for (int i = 0; i < len; i++) {
            int idx = Arrays.binarySearch(nums, 0, nLen, queries[i]);
            ret[i] = idx < 0 ? Math.abs(idx + 1) : idx + 1;
        }

        return ret;
    }

    public int[] answerQueriesTreeMap(int[] nums, int[] queries) {
        int len = queries.length;
        int[] ret = new int[len];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        Arrays.sort(nums);
        for (int i = 0, nLen = nums.length; i < nLen; i++)
            if (i == 0)
                map.put(nums[0], 1);
            else
                map.put(map.lastKey() + nums[i], i + 1);

        for (int i = 0; i < len; i++) {
            Map.Entry<Integer, Integer> e = map.floorEntry(queries[i]);
            ret[i] = e == null ? 0 : e.getValue();
        }

        return ret;
    }

}
