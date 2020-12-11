package us.supercheng.algorithm.problems.leetcode.kidswiththegreatestnumberofcandies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies.length == 1)
            return Arrays.asList(true);

        int max = candies[0];
        List<Boolean> ret = new ArrayList<>();

        for (int c : candies)
            if (c > max)
                max = c;

        for (int c : candies)
            if (c + extraCandies >= max)
                ret.add(true);
            else
                ret.add(false);

        return ret;
    }

}
