package us.supercheng.algorithm.problems.algo.radixsort;

import java.util.*;

public class Progam {

    public ArrayList<Integer> radixSort_Solution1(ArrayList<Integer> array) {
        if (array == null || array.size() < 2)
            return array;

        int digits = 0;
        for (int max = Collections.max(array); max != 0; max /= 10)
            digits++;

        ArrayList<Integer> ret = new ArrayList<>(array);
        for (int d=0; d<=digits; d++)
            ret = this.radixSort1(ret, d);

        return ret;
    }

    private ArrayList<Integer> radixSort1(ArrayList<Integer> arr, int digit) {
        int[] bucket = new int[10];
        ArrayList<Integer> ret = new ArrayList<>(arr);

        for (int val : arr)
            bucket[(int) (val / Math.pow(10, digit) % 10)]++;

        for (int i=1; i<10; i++)
            bucket[i] = bucket[i - 1] + bucket[i];

        for (int idx=arr.size() - 1; idx > -1; idx--) {
            int val = arr.get(idx);
            ret.set(--bucket[(int) (val / Math.pow(10, digit) % 10)], val);
        }

        return ret;
    }

    public ArrayList<Integer> radixSort(ArrayList<Integer> array) {
        if (array == null || array.size() < 2)
            return array;

        int digits = 0;
        for (int max = Collections.max(array); max != 0; max /= 10)
            digits++;

        ArrayList<Integer> ret = new ArrayList<>(array);
        for (int d = 0; d <= digits; d++)
            ret = this.radixSort(ret, d);

        return ret;
    }

    private ArrayList<Integer> radixSort(ArrayList<Integer> arr, int digit) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        ArrayList<Integer> ret = new ArrayList<>();

        for (int val : arr) {
            int idx = (int) (val / Math.pow(10, digit) % 10);
            if (!map.containsKey(idx))
                map.put(idx, new ArrayList<>());
            map.get(idx).add(val);
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet())
            for (int num : entry.getValue())
                ret.add(num);

        return ret;
    }
}