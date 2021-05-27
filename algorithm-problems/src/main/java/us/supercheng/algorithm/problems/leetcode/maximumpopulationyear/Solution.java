package us.supercheng.algorithm.problems.leetcode.maximumpopulationyear;

public class Solution {

    public int maximumPopulation(int[][] logs) {
        int[] bucket = new int[101];
        int ret = 0;
        int max = 0;

        for (int[] log : logs)
            for (int from=log[0], to=log[1]; from<to; from++)
                bucket[from - 1950]++;

        for (int i=0; i<101; i++)
            if (bucket[i] > max) {
                max = bucket[i];
                ret = i + 1950;
            }

        return ret;
    }

}
