package us.supercheng.algorithm.problems.algo.monotonicarray;

import java.util.*;

public class Program {

    public static boolean isMonotonic_Solution1(int[] array) {
        for (int inc = 0, curr = 1, len = array.length; curr < len; curr++) {
            int currVal = array[curr],
                prevVal = array[curr-1];

            if (prevVal < currVal) {
                if (inc == 0)
                    inc = 1;
                else if (inc == -1)
                    return false;
            } else if (prevVal > currVal) {
                if (inc == 0)
                    inc = -1;
                else if (inc == 1)
                    return false;
            }
        }

        return true;
    }

    public static boolean isMonotonic_Solution2(int[] array) {
        if (array == null || array.length < 3)
            return true;

        boolean isInc = false,
                isDec = false;

        for (int i=1, len = array.length; !(isInc && isDec) && i<len; i++) {
            if (array[i-1] < array[i])
                isInc = true;
            if (array[i-1] > array[i])
                isDec = true;
        }

        return (!isInc && !isDec) || isInc != isDec;
    }
}

