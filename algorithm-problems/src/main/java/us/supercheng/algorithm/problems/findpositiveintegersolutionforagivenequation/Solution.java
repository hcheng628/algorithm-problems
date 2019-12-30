package us.supercheng.algorithm.problems.findpositiveintegersolutionforagivenequation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i=1;i<=z;i++)
            for (int j = z - i + 1;j>0;j--)
                if (customfunction.f(i, j) == z)
                    ret.add(Arrays.asList(new Integer[]{i, j}));
        return ret;
    }

    class CustomFunction {
        public int f(int a, int b) {
            return a+b; // just to pass compile
        }
    }
}