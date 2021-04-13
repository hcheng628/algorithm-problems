package us.supercheng.algorithm.problems.leetcode.signoftheproductofanarray;

public class Solution {

    public int arraySign(int[] nums) {
        boolean isNegative = false;

        for (int n : nums)
            if (n == 0)
                return 0;
            else if (n < 0)
                isNegative ^= true;

        return isNegative ? -1 : 1;
    }

}
