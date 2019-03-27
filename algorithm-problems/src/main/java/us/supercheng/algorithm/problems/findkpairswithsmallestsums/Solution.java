package us.supercheng.algorithm.problems.findkpairswithsmallestsums;

import java.util.*;

class Solution {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        Map<Integer, List<int[]>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<nums1.length;i++)
            for (int j=0;j<nums2.length;j++) {
                int res = nums1[i] + nums2[j];
                int [] arr = {nums1[i],nums2[j]};
                if (!map.containsKey(res)) {
                    map.put(res, new ArrayList<>());
                    list.add(res);
                }
                map.get(res).add(arr);
            }

        List<int[]> ret = new ArrayList<>();
        Collections.sort(list);

        for(int idx = 0;ret.size() <k && idx<list.size();idx++) {
            List<int[]> each = map.get(list.get(idx));
            for (int i=0;i<each.size() && ret.size()<k; i++)
                ret.add(each.get(i));
        }

        return ret;
    }
}