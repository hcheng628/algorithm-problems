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
}
