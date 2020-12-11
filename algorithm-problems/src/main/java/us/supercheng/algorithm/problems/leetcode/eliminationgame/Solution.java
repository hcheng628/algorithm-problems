package us.supercheng.algorithm.problems.leetcode.eliminationgame;

class Solution {
    public int lastRemaining(int n) {
        return this.helper(n, true);
    }

    private int helper(int n, boolean fromLeft) {
        if (n == 1)
            return 1;

        int ret = -1;
        if (fromLeft)
            ret = 2 * this.helper(n/2, false);
        else {
            ret = 2 * this.helper(n/2, true);
            if (n % 2 == 0)
                ret--;
        }
        return ret;
    }
}