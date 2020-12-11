package us.supercheng.algorithm.problems.leetcode.distributecandiestopeople;

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        if (num_people < 1)
            return null;
        else if (candies < 1)
            return new int[num_people];

        int[] ret = new int[num_people];

        for(int n=1, idx = 0;candies > 0; idx++,candies -=n++)
            if (n > candies) {
                ret[idx % num_people] += candies;
                break;
            } else
                ret[idx % num_people] += n;

        return ret;
    }
}