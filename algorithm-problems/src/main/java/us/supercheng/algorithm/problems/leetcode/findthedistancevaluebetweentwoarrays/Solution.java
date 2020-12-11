package us.supercheng.algorithm.problems.leetcode.findthedistancevaluebetweentwoarrays;

import java.util.Arrays;

public class Solution {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ret = 0,
            len2 = arr2.length;

        Arrays.sort(arr2);

        for (int a : arr1) {
            int idx = Arrays.binarySearch(arr2, a);
            if (idx < 0) {
                idx = -(++idx);
                if (idx == 0) {
                    if (Math.abs(a - arr2[idx]) > d)
                        ret++;
                } else if (idx == len2) {
                    if (Math.abs(a - arr2[idx-1]) > d)
                        ret++;
                } else {
                    if (Math.abs(a - arr2[idx]) > d && Math.abs(a - arr2[idx-1]) > d)
                        ret++;
                }
            }
        }

        return ret;
    }
}