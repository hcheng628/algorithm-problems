package us.supercheng.algorithm.problems.algo.subarraysort;

import java.util.*;

public class Program {

    // Time: O(nlog(n) Space: O(n)
    public static int[] subarraySort_Solution1(int[] array) {
        int len = array.length;
        int start = -1;
        int end = -1;
        int[] sorted = new int[len];

        System.arraycopy(array, 0, sorted, 0, len);
        Arrays.sort(sorted);

        for (int i=0; start==-1 && i<len; i++)
            if (sorted[i] != array[i])
                start = i;

        if (start == -1)
            return new int[]{-1, -1};

        for (int i=len-1; end==-1 && i>-1; i--)
            if (sorted[i] != array[i])
                end = i;

        return new int[] {start, end};
    }



}