package us.supercheng.algorithm.problems.algo.threenumbersum;

import java.util.*;

public class Program {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> ret = new ArrayList<Integer[]>();
        Arrays.sort(array);

        for (int i=0, len = array.length; i<len; i++)
            for (int j=i+1; j<len; j++) {
                int a = array[i],
                    b = array[j],
                    c = targetSum - a - b;

                if (Arrays.binarySearch(array, c) > j)
                    ret.add(new Integer[]{a, b, c});
            }

        return ret;
    }
}
