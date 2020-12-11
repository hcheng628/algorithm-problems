package us.supercheng.algorithm.problems.leetcode.minimumtimedifference;

import java.util.*;

class Solution {

    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.size() < 2)
            throw new IllegalArgumentException("Invalid Param");

        List<Integer> list = new ArrayList<>();
        int ret = 1440;

        for (int i=0;i<timePoints.size();i++)
            try {
                String each = timePoints.get(i);
                int idx = each.indexOf(":"),
                        res = Integer.parseInt(each.substring(0, idx)) * 60 + Integer.parseInt(each.substring(idx+1));
                if (list.isEmpty()) {
                    list.add(res);
                } else {
                    int insertIdx = Collections.binarySearch(list, res);
                    if (insertIdx < 0)
                        list.add(-insertIdx-1, res);
                    else
                        return 0;
                }

            } catch (Exception ex) {
                throw new IllegalArgumentException("Invalid Param");
            }

        int len = list.size();
        for (int i=1;i<len;i++)
            ret = Math.min(list.get(i) - list.get(i-1), ret);

        return Math.min(1440 - list.get(len-1) + list.get(0), ret);
    }
}