package us.supercheng.algorithm.problems.algo.sortksortedarray;

import java.util.*;

public class Program {

    public int[] sortKSortedArray(int[] array, int k) {
        if (array == null || array.length < 2)
            return array;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int len = array.length;
        int idx = 0;

        for (int i=0; i<=k && i<len; i++)
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);

        for (int end=len-k; idx<end; idx++) {
            array[idx] = map.firstKey();

            if (map.get(array[idx]) == 1)
                map.remove(array[idx]);
            else
                map.put(array[idx], map.get(array[idx]) - 1);
            if (idx + k + 1 < len)
                map.put(array[idx + k + 1], map.getOrDefault(array[idx + k + 1], 0) + 1);
        }

        for (; !map.isEmpty(); idx++) {
            array[idx] = map.firstKey();
            map.put(array[idx], map.get(array[idx]) - 1);
            if (map.get(array[idx]) == 0)
                map.remove(array[idx]);
        }

        return array;
    }

    public static void main(String[] args) {
        new Program().sortKSortedArray(new int[]{3, 2, 1, 5, 4, 7, 6, 5}, 3);
    }

}
