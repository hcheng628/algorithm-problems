package us.supercheng.algorithm.problems.algo.longestpeak;

import java.util.*;

public class Program {
    public static int longestPeak_Solution1(int[] array) {
        int ret = 0;

        for (int i=0, len=array.length; i<len; i++) {
            int left = 0,
                    right = 0;

            for (int j=i-1; j>-1 && array[j] < array[j+1];j--)
                left++;

            for (int j=i; j<len-1 && array[j]>array[j+1]; j++)
                right++;

            if (left > 0 && right > 0 && left + right + 1 > 2)
                ret = Math.max(left + right + 1, ret);
        }

        return ret;
    }

    public static int longestPeak_Solution2(int[] array) {
        int len = array.length,
            ret = 0;
        int[] incArr = new int[len],
              decArr = new int[len];

        for (int i=1; i<len; i++)
            if (array[i-1] < array[i])
                incArr[i] = incArr[i-1] + 1;

        for (int i=len-2; i>-1; i--)
            if (array[i] > array[i+1])
                decArr[i] = decArr[i+1] + 1;

        for (int i=1; i<len-1; i++)
            if (incArr[i] > 0 && decArr[i] > 0 && incArr[i] + decArr[i] + 1 > ret)
                ret = incArr[i] + decArr[i] + 1;

        return ret;
    }

    public static int longestPeak_Solution3(int[] array) {
        int ret = 0;
        for (int idx=1, len=array.length-1; idx<len;)
            if (array[idx-1] < array[idx] && array[idx] > array[idx+1]) {
                int left = 0,
                    right = 0;

                for (int j=idx; j-1>-1 && array[j-1] < array[j]; j--)
                    left++;

                for (int j=idx; j<=len-1 && array[j] > array[j+1]; j++)
                    right++;

                idx += right;
                ret = Math.max(left + right + 1, ret);
            } else
                idx++;

        return ret;
    }
}

