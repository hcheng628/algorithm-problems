package us.supercheng.algorithm.problems.leetcode.maximumunitsonatruck;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int ret = 0;

        Arrays.sort(boxTypes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            };
        });

        for (int i=0, len=boxTypes.length; i<len && truckSize != 0; i++) {
            int amt = boxTypes[i][0];
            int unit = boxTypes[i][1];

            if (amt <= truckSize) {
                ret += amt * unit;
                truckSize -= amt;
            } else {
                ret += truckSize * unit;
                truckSize = 0;
            }
        }

        return ret;
    }
}