package us.supercheng.algorithm.problems.algo.kadanesalgorithm;

import java.util.*;

public class Program {

    public static int kadanesAlgorithm_Solution1(int[] array) {
        int ret = Integer.MIN_VALUE;

        for (int i=0, len = array.length; i<len; i++) {
            int curr = 0;
            for (int j=i; j<len; j++) {
                curr += array[j];
                ret = Math.max(curr, ret);
            }
        }

        return ret;
    }

    public static int kadanesAlgorithm_Solution2(int[] array) {
        int prev = array[0],
            ret = prev;

        for (int i=1, len = array.length; i<len; i++) {
            int curr = Math.max(array[i], array[i] + prev);
            ret = Math.max(curr, ret);
            prev = curr;
        }

        return ret;
    }
}
