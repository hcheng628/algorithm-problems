package us.supercheng.algorithm.problems.leetcode.findkpairswithsmallestsums;

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

    public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<>();

        int m = nums1.length,
                n = nums2.length;

        if (nums1 == null || nums2 == null || m == 0 || n ==0)
            return ret;

        Queue<Pair> queue = new PriorityQueue<>();

        for (int i=0;i<nums1.length && i<k;i++) {
            queue.offer(new Pair(i, 0, nums1[i] + nums2[0]));
        }

        // for (Pair each : queue)
        //     PrintHelper.echoLn(each.sum + " === " + nums1[each.idxA] + " === " + nums2[each.idxB]);

        while (k-- >0 && !queue.isEmpty()) {
            Pair pair = queue.poll();

            ret.add(new int [] {nums1[pair.idxA], nums2[pair.idxB]});

            if (pair.idxB + 1 >= n)
                continue;
            queue.offer(new Pair(pair.idxA, pair.idxB+1, nums1[pair.idxA] + nums2[pair.idxB+1]));
        }

        return ret;
    }

    class Pair implements Comparable<Pair>{
        int idxA;
        int idxB;
        int sum;

        Pair (int idxA, int idxB, int sum) {
            this.idxA = idxA;
            this.idxB = idxB;
            this.sum = sum;
        }

        @Override
        public int compareTo(Pair that) {
            return this.sum - that.sum;
        }
    }
}