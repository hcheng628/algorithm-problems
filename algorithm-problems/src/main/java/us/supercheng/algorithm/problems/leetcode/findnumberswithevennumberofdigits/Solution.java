package us.supercheng.algorithm.problems.leetcode.findnumberswithevennumberofdigits;

public class Solution {

    public int findNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums)
            if (this.isEvenDigs(n))
                ret++;

        return ret;
    }

    private boolean isEvenDigs(int n) {
        if (n < 10)
            return false;

        int count = 0;
        for (;n!=0;n/=10)
            count++;

        return count % 2 == 0;
    }
}