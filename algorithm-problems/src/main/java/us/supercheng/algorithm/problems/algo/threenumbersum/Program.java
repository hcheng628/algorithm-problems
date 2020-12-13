package us.supercheng.algorithm.problems.algo.threenumbersum;

import java.util.*;

public class Program {

    public static List<Integer[]> threeNumberSum_Solution1(int[] array, int targetSum) {
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

    public static List<Integer[]> threeNumberSum_Solution2(int[] array, int targetSum) {
        List<Integer[]> ret = new ArrayList<>();
        Arrays.sort(array);

        for (int i=0, len=array.length; i<len-2; i++)
            for (int j=i+1; j<len-1; j++)
                for (int k=j+1; k<len; k++) {
                    int res = array[i] + array[j] + array[k];
                    if (res == targetSum)
                        ret.add(new Integer[]{array[i], array[j], array[k]});
                    else if (res > targetSum)
                        break;
                }

        return ret;
    }

}
