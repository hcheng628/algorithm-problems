package us.supercheng.algorithm.problems.algo.smallestdifference;

import java.util.*;

public class Program {

    public static int[] smallestDifference_Solution1(int[] arrayOne, int[] arrayTwo) {
        int[] ret = new int[2];
        Arrays.sort(arrayTwo);
        Integer diff = null;

        for (int i=0, len=arrayOne.length, len2=arrayTwo.length; i<len; i++) {
            int valOne = arrayOne[i],
                idx = Arrays.binarySearch(arrayTwo, valOne);

            if (idx > -1)
                return new int[]{valOne, valOne};

            idx = (-idx) - 1;
            if (idx == len2)
                idx--;

            if (diff == null || Math.abs(arrayTwo[idx] - valOne) < diff) {
                diff = Math.abs(arrayTwo[idx] - valOne);
                ret[0] = valOne;
                ret[1] = arrayTwo[idx];
            }

            if (idx - 1 > -1 && Math.abs(arrayTwo[idx-1] - valOne) < diff) {
                diff = Math.abs(arrayTwo[idx-1] - valOne);
                ret[0] = valOne;
                ret[1] = arrayTwo[idx-1];
            }

            if (idx + 1 < len2 && Math.abs(arrayTwo[idx+1] - valOne) < diff) {
                diff = Math.abs(arrayTwo[idx+1] - valOne);
                ret[0] = valOne;
                ret[1] = arrayTwo[idx+1];
            }
        }

        return ret;
    }

    public static int[] smallestDifference_Solution2(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int idxOne = 0,
            idxTwo = 0,
            lenOne = arrayOne.length,
            lenTwo = arrayTwo.length,
            diff = Math.max(arrayOne[lenOne-1], arrayTwo[lenTwo-1]) - Math.min(arrayOne[0], arrayTwo[0]);
        int[] ret = new int[2];

        while (idxOne < lenOne && idxTwo < lenTwo) {
            int valOne = arrayOne[idxOne],
                    valTwo = arrayTwo[idxTwo];

            if (valOne == valTwo)
                return new int[]{valOne, valTwo};
            else if (valOne > valTwo)
                idxTwo++;
            else
                idxOne++;

            if (Math.abs(valOne - valTwo) < diff) {
                diff = Math.abs(valOne - valTwo);
                ret[0] = valOne;
                ret[1] = valTwo;
            }
        }

        return ret;
    }
}

