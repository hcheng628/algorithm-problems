package us.supercheng.algorithm.problems.algo.twonumbersum;

import java.util.*;

public class Program {

    public static int[] twoNumberSum_Solution1(int[] array, int targetSum) {
        Arrays.sort(array);

        for (int i=0, len = array.length; i<len; i++) {
            int a = array[i],
                b = targetSum - a;
            if (Arrays.binarySearch(array, b) > i)
                return new int[]{a, b};
        }

        return new int[0];
    }

    public static int[] twoNumberSum_Solution2(int[] array, int targetSum) {
        for (int i=0, len=array.length; i<len; i++)
            for (int j=0; j<len; j++) {
                if (i == j)
                    continue;
                int a = array[i],
                        b = array[j];
                if (a + b == targetSum)
                    return new int[]{a, b};
            }

        return new int[0];
    }

    public static int[] twoNumberSum_Solution3(int[] array, int targetSum) {
        Set<Integer> set = new HashSet<>();

        for (int a : array) {
            int res = targetSum - a;
            if (set.contains(res))
                return new int[]{a, res};
            set.add(a);
        }

        return new int[0];
    }

    public static int[] twoNumberSum_Solution4(int[] array, int targetSum) {
        Arrays.sort(array);

        int len = array.length,
            left = 0,
            right = len - 1;

        while (left < right) {
            int val = array[left] + array[right];
            if (val == targetSum)
                return new int[]{array[left], array[right]};
            else if (val < targetSum)
                left++;
            else
                right--;
        }

        return new int[0];
    }
}