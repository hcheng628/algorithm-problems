package us.supercheng.algorithm.problems.buildanarraywithstackoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<String> buildArray(int[] target, int n) {
        List<String> ret = new ArrayList<>();

        for (int i=1, idx = 0, stop = target.length; idx != stop && i<=n; i++)
            if (i == target[idx]) {
                ret.add("Push");
                idx++;
            } else
                ret.addAll(Arrays.asList("Push", "Pop"));

        return ret;
    }
}
// build-an-array-with-stack-operations