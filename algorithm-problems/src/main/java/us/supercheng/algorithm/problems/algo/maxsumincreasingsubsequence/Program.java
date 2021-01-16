package us.supercheng.algorithm.problems.algo.maxsumincreasingsubsequence;

import java.util.*;

public class Program {

    // Time: O(n^2) Space: O(n^2)
    public static List<List<Integer>> maxSumIncreasingSubsequence_Solution1(int[] array) {
        List<List<List<Integer>>> dp = new ArrayList<>();
        dp.add(buildRet(Arrays.asList(array[0])));
        List<List<Integer>> ret = dp.get(0);

        for (int i=1, len = array.length; i<len; i++) {
            List<List<Integer>> currRet = buildRet(Arrays.asList(array[i]));
            for (int j=0; j<i; j++) {
                int lastVal = getLastVal(dp.get(j));
                int newSum = getSum(dp.get(j)) + array[i];
                if (lastVal > 0 && lastVal < array[i] && newSum > getSum(currRet)) {
                    List<Integer> tmp = new ArrayList<>(dp.get(j).get(1));
                    tmp.add(array[i]);
                    currRet = buildRet(tmp);
                }
            }
            dp.add(currRet);
            if (getSum(currRet) > getSum(ret))
                ret = currRet;
        }

        return ret;
    }

    private static int getLastVal(List<List<Integer>> ret) {
        return ret.get(1).get(ret.get(1).size() - 1);
    }

    private static int getSum(List<List<Integer>> ret) {
        return ret.get(0).get(0);
    }

    private static List<List<Integer>> buildRet(List<Integer> list) {
        int sum = 0;
        for (int l : list)
            sum += l;
        final int ret = sum;
        return new ArrayList<List<Integer>>() {
            {
                add(Arrays.asList(ret));
                add(list);
            }
        };
    }

    // Time: O(n^2) Space: O(n)
    public static List<List<Integer>> maxSumIncreasingSubsequence_Solution2(int[] array) {
        int len = array.length;
        int idx = 0;
        int[] sum = new int[len];
        Integer[] indices = new Integer[len];
        System.arraycopy(array, 0, sum, 0, len);

        for (int i=0; i<len; i++) {
            for (int j=0; j<i; j++)
                if (array[j] < array[i] && sum[j] + array[i] > sum[i]) {
                    sum[i] = sum[j] + array[i];
                    indices[i] = j;
                }

            if (sum[i] > sum[idx])
                idx = i;
        }

        return buildRet(array, indices, idx, sum[idx]);
    }

    private static List<List<Integer>> buildRet(int[] arr, Integer[] indices, int idx, int sum) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[idx]);

        for (; indices[idx] != null; idx = indices[idx])
            list.add(0, arr[indices[idx]]);

        return new ArrayList<List<Integer>>() {
            {
                add(Arrays.asList(sum));
                add(list);
            }
        };
    }
}




