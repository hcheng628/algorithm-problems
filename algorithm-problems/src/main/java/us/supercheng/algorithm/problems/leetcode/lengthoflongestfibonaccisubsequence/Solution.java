package us.supercheng.algorithm.problems.leetcode.lengthoflongestfibonaccisubsequence;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int lenLongestFibSubseq(int[] A) {
        int ret = 0;

        Set<Integer> set = new HashSet<>();
        for (int a : A)
            set.add(a);

        for (int i=0, len=A.length; i<len; i++)
            for (int j=i+1; j<len; j++) {
                int a = A[i],
                    b = A[j],
                    c = b + a,
                    res = 2;

                while (set.contains(c)) {
                    a = b;
                    b = c;
                    c = a + b;
                    ret = Math.max(++res, ret);
                }
            }

        return ret;
    }
}