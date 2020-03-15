package us.supercheng.algorithm.problems.mostprofitassigningwork;

import java.util.*;

public class Solution {

    public int maxProfitAssignmentBucket(int[] difficulty, int[] profit, int[] worker) {
        int ret = 0,
            size = 100001;
        int[] bucket = new int[size];

        for (int i=0;i<difficulty.length;i++)
            bucket[i] = Math.max(profit[i], bucket[i]);

        for (int i=1;i<size;i++)
            bucket[i] = Math.max(bucket[i-1], bucket[i]);

        for (int w : worker)
            ret += bucket[w];

        return ret;
    }

    public int maxProfitAssignmentTLE(int[] difficulty, int[] profit, int[] worker) {
        int ret = 0;
        TreeMap<Integer, Integer> difMap = new TreeMap<Integer, Integer>();

        for (int idx=difficulty.length-1;idx>-1;idx--)
            if (!difMap.containsKey(difficulty[idx]) || profit[difMap.get(difficulty[idx])] < profit[idx])
                difMap.put(difficulty[idx], idx);

        for (int w : worker) {
            Integer max = difMap.lowerKey(w+1);
            if (max != null)
                ret += this.getMaxP(difMap, difMap.get(max), max, profit);
        }

        return ret;
    }

    private int getMaxP(TreeMap<Integer, Integer> map, int maxIdx, int maxVal, int[] p) {
        int ret = p[maxIdx];

        while (map.lowerKey(maxVal) != null) {
            int res = map.lowerKey(maxVal),
                profit = p[map.get(res)];
            if (profit > ret)
                ret = profit;
            maxVal = res;
        }

        return ret;
    }

    public int maxProfitAssignmentGreddy(int[] difficulty, int[] profit, int[] worker) {
        int ret = 0,
            len = difficulty.length;
        List<int[]> list = new ArrayList<>();

        for (int i=0;i<len;i++)
            list.add(new int[]{difficulty[i], profit[i]});

        Arrays.sort(worker);
        Collections.sort(list, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int idx = 0,
            max = 0;

        for (int w : worker) {
            for (;idx < len && w >= list.get(idx)[0];idx++)
                max = Math.max(max, list.get(idx)[1]);
            ret += max;
        }

        return ret;
    }
}