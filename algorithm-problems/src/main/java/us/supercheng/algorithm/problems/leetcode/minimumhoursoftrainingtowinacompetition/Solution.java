package us.supercheng.algorithm.problems.leetcode.minimumhoursoftrainingtowinacompetition;

import java.util.Arrays;

class Solution {

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ret = Math.max(Arrays.stream(energy).sum() - initialEnergy + 1, 0);

        for (int e : experience) {
            if (initialExperience <= e) {
                ret += e - initialExperience + 1;
                initialExperience = e + 1;
            }
            initialExperience += e;
        }

        return ret;
    }

}