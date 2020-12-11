package us.supercheng.algorithm.problems.leetcode.sortintegersbythenumberof1bits;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int[] sortByBits(int[] arr) {
        int len = arr.length;
        Integer[] list = new Integer[len];

        for (int i=0; i<len; i++)
            list[i] = arr[i];

        Arrays.sort(list, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int countA = 0,
                        countB = 0;

                for (int aa=a; aa>0;aa >>= 1)
                    countA += (aa & 1);

                for (int bb=b; bb>0;bb >>= 1)
                    countB += (bb & 1);

                return countA * 10000 + a > countB * 10000 + b ? 1 : -1;
            }
        });


        for (int i=0; i<len; i++)
            arr[i] = list[i];

        return arr;
    }
}
