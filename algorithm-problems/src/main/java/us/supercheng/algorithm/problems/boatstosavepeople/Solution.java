package us.supercheng.algorithm.problems.boatstosavepeople;

import java.util.Arrays;

public class Solution {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ret = 0;

        for (int slim=0, fat=people.length-1; slim<=fat; fat--)
            if (fat == slim)
                ret++;
            else {
                if (people[slim] + people[fat] <= limit)
                    slim++;
                ret++;
            }

        return ret;
    }
}
