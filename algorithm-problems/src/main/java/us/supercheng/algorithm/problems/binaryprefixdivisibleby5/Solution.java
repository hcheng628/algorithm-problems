package us.supercheng.algorithm.problems.binaryprefixdivisibleby5;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ret = new ArrayList<>();
        int num = 0;
        for (int i=0;i<A.length;i++) {
            num = ((num * 2) + A[i]) % 10;
            ret.add(num % 5 == 0);
        }
        return ret;
    }
}