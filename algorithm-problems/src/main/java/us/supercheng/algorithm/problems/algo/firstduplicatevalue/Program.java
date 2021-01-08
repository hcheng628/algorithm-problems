package us.supercheng.algorithm.problems.algo.firstduplicatevalue;

import java.util.*;

public class Program {

    public int firstDuplicateValue_Solution1(int[] array) {
        Set<Integer> set = new HashSet<>();

        for (int a : array)
            if (set.contains(a))
                return a;
            else
                set.add(a);

        return -1;
    }

    public int firstDuplicateValue_Solution2(int[] array) {
        int len = array.length;
        int idx = len;

        for (int i=0; i<len; i++)
            for (int j=i+1; j<len; j++)
                if (array[i] == array[j])
                    if (j < idx)
                        idx = j;

        return idx == len ? -1 : array[idx];
    }

    public int firstDuplicateValue_Solution3(int[] array) {
        for (int i=0, len=array.length; i<len; i++) {
            int val = Math.abs(array[i]);

            if (array[val - 1] < 0)
                return Math.abs(array[i]);

            array[val - 1] = -array[val - 1];
        }

        return -1;
    }
}
